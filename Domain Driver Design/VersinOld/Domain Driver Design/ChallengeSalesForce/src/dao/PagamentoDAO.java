package dao;

import connections.ConnectionFactory;
import model.entities.Pagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PagamentoDAO {

    private final Connection myConnection;

    public PagamentoDAO(Connection connection) throws ClassNotFoundException, SQLException {
        this.myConnection = connection;
    }

    public void insert(Pagamento pagamento) throws SQLException {

        PreparedStatement stmt = myConnection.prepareStatement(
                """
                            INSERT INTO TB_PAGAMENTO (data_pagamento, valor_total, forma_pagamento, parcelas, valor_parcelas, descricao, status)
                            VALUES (TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?, ?, ?, ?)
                        """, new String[]{"id_pagamento"}
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
                pagamento.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("Erro ao obter o ID do pagamento.");
            }
        } else {
            throw new SQLException("A inserção falhou.");
        }

        stmt.close();
    }


    public Pagamento findById(long idPagamento) {
        try {
            PreparedStatement stmt = myConnection.prepareStatement(
                    """
                                SELECT * FROM TB_PAGAMENTO
                                WHERE id_pagamento = ?
                            """
            );

            stmt.setLong(1, idPagamento);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Pagamento pagamento = new Pagamento(
                        rs.getLong("id_pagamento"),
                        rs.getString("data_pagamento"),
                        rs.getDouble("valor_total"),
                        rs.getString("forma_pagamento"),
                        rs.getInt("parcelas"),
                        rs.getDouble("valor_parcelas"),
                        rs.getString("descricao"),
                        rs.getString("status")
                );

                stmt.close();
                return pagamento;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
