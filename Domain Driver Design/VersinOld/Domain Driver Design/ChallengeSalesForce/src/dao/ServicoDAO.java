package dao;

import connections.ConnectionFactory;
import model.entities.Servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {

    private final Connection myConnection;

    public ServicoDAO(Connection connection) {
        this.myConnection = connection;
    }

    public void insert(Servico servico) throws SQLException {

        PreparedStatement stmt = myConnection.prepareStatement(
                "INSERT INTO tb_servico (nome, categoria, valor) values ( ?, ?, ?)"
        );

        stmt.setString(1, servico.getNome());
        stmt.setString(2, servico.getCategoria());
        stmt.setDouble(3, servico.getValor());

        stmt.execute();
        stmt.close();

    }

    public Integer getId(Servico servico) throws SQLException {
        PreparedStatement stmt = myConnection.prepareStatement(
                "SELECT id_servico FROM tb_servico WHERE nome = ? AND categoria = ? AND valor = ?"
        );

        stmt.setString(1, servico.getNome());
        stmt.setString(2, servico.getCategoria());
        stmt.setDouble(3, servico.getValor());

        Integer id = null;
        try {
            var rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_servico");
            }
        } finally {
            stmt.close();
        }

        return id;
    }

    public List<Servico> findAll() throws SQLException {
        PreparedStatement stmt = myConnection.prepareStatement(
                "SELECT * FROM tb_servico"
        );
        ResultSet rs = stmt.executeQuery();

        List<Servico> servicos = new ArrayList<>();

        try{
            while (rs.next()) {
                servicos.add(new Servico(
                        rs.getInt("id_servico"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getString("categoria"),
                        rs.getDouble("valor")
                    ));
            }
        } finally {
            stmt.close();
            rs.close();
        }

        return servicos;
    }

    public Servico findById(int id) throws SQLException {
        PreparedStatement stmt = myConnection.prepareStatement(
                "SELECT * FROM tb_servico WHERE id_servico = ?"
        );
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        Servico servico = null;

        try {
            if (rs.next()) {
                servico = new Servico(
                        rs.getInt("id_servico"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getString("categoria"),
                        rs.getDouble("valor")
                );
            }
        } finally {
            stmt.close();
            rs.close();
        }

        return servico;
    }
}
