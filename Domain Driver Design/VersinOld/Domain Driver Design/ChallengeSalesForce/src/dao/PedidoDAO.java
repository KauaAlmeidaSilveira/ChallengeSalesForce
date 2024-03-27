package dao;

import connections.ConnectionFactory;
import model.entities.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    private final Connection myConnection;

    public PedidoDAO(Connection connection) throws ClassNotFoundException, SQLException {
        this.myConnection = connection;
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


    public List<Pedido> findAll() throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = myConnection.prepareStatement(
                """
                        SELECT * FROM TB_PEDIDO
                    """
        );

        ResultSet rs = stmt.executeQuery();

        List<Pedido> pedidos = new ArrayList<>();

        while (rs.next()) {
            pedidos.add(
                    new Pedido(
                            rs.getLong("id_pedido"),
                            new ContaDAO(myConnection).findById(rs.getInt("id_conta")),
                            new ServicoDAO(myConnection).findById(rs.getInt("id_servico")),
                            new PagamentoDAO(myConnection).findById(rs.getLong("id_pagamento")),
                            rs.getString("data_pedido")
                    )
            );
        }

        stmt.close();

        return pedidos;
    }
}
