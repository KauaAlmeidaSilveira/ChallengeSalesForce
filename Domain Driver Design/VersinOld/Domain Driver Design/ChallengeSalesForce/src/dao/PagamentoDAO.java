package dao;

import connections.ConnectionFactory;
import model.entities.Pagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PagamentoDAO {

    public final Connection myConnection;

    public PagamentoDAO() throws SQLException, ClassNotFoundException {
        this.myConnection = new ConnectionFactory().getConnection();
    }

    public void insert(Pagamento pagamento) throws SQLException {

        PreparedStatement stmt = myConnection.prepareStatement(
                """
                            INSERT INTO TB_PAGAMENTO (data_pagamento, valor_total, forma_pagamento, parcelas, valor_parcelas, descricao, status)
                            VALUES (TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?, ?, ?, ?)
                        """,
                PreparedStatement.RETURN_GENERATED_KEYS
        );

        stmt.setString(1, pagamento.getDataPagamento());
        stmt.setDouble(2, pagamento.getValorTotal());
        stmt.setString(3, pagamento.getFormaPagamento());
        stmt.setInt(4, pagamento.getParcelas());
        stmt.setDouble(5, pagamento.getValorParcelas());
        stmt.setString(6, pagamento.getDescricao());
        stmt.setString(7, pagamento.getStatus());

        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected == 1) {
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                pagamento.setId(generatedKeys.getInt(1)); // Erro no getGeneratedKeys pois não está retornando o ID
            } else {
                throw new SQLException("Erro ao obter o ID do pagamento.");
            }
        } else {
            throw new SQLException("A inserção falhou.");
        }

        stmt.close();
    }


}
