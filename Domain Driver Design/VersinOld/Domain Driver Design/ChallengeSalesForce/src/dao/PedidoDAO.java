package dao;

import connections.ConnectionFactory;
import model.entities.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoDAO {

    private final Connection myConnection;

    public PedidoDAO() throws SQLException, ClassNotFoundException {
        this.myConnection = new ConnectionFactory().getConnection();
    }

    public void insert(Pedido pedido) throws SQLException {

        PreparedStatement stmt = myConnection.prepareStatement(
                """
                        INSERT INTO TB_PEDIDO (id_conta, id_pagamento, id_servico, data_pedido)
                        VALUES (?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'))
                    """, new String[] {"id_pedido"}
        );

        stmt.setInt(1, pedido.getConta().getId());
        stmt.setLong(2, pedido.getPagamento().getId());
        stmt.setInt(3, pedido.getServico().getId());
        stmt.setString(4, pedido.getDataPedido());

        int rowsAffected = stmt.executeUpdate();

        if(rowsAffected == 1){
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if(generatedKeys.next()) {
                pedido.setId(generatedKeys.getLong(1));
            }else {
                throw new SQLException("Erro ao obter o ID do pedido.");
            }
        }else {
            throw new SQLException("A inserção falhou.");
        }

        stmt.close();

    }




}
