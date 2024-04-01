package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Endereco;

public class EnderecoDAO {

    private final Connection myConnection;

    public EnderecoDAO(Connection connection){
        this.myConnection = connection;
    }

    public void insert(Endereco endereco) throws SQLException {

        PreparedStatement stmt = myConnection.prepareStatement(
                "INSERT INTO tb_endereco (rua, cidade, estado, cep) values (?, ?, ?, ?)"
        );

        stmt.setString(1, endereco.getRua());
        stmt.setString(2, endereco.getCidade());
        stmt.setString(3, endereco.getEstado());
        stmt.setString(4, endereco.getCep());

        stmt.execute();
        stmt.close();

    }

    public Integer getId(Endereco endereco) throws SQLException {
        PreparedStatement stmt = myConnection.prepareStatement(
                "SELECT id_endereco FROM tb_endereco WHERE rua = ? AND cidade = ? AND estado = ? AND cep = ?"
        );

        stmt.setString(1, endereco.getRua());
        stmt.setString(2, endereco.getCidade());
        stmt.setString(3, endereco.getEstado());
        stmt.setString(4, endereco.getCep());

        Integer id = null;
        try {
            var rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_endereco");
            }
        } finally {
            stmt.close();
        }

        return id;
    }

    public List<Endereco> findAll() throws SQLException {
        PreparedStatement stmt = myConnection.prepareStatement("SELECT * FROM tb_endereco");
        ResultSet rs = stmt.executeQuery();

        List<Endereco> enderecos = new ArrayList<>();

        try {
            while (rs.next()) {
                enderecos.add(new Endereco(
                        rs.getInt("id_endereco"),
                        rs.getString("rua"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("cep"),
                        rs.getString("pais")
                ));
            }
        } finally {
            stmt.close();
            rs.close();
        }

        return enderecos;
    }

    public Endereco findById(Integer id) throws SQLException {
        PreparedStatement stmt = myConnection.prepareStatement(
                "SELECT * FROM tb_endereco WHERE id_endereco = ?"
        );

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        try (stmt){

            if (rs.next()) {
            return new Endereco(
                    rs.getInt("id_endereco"),
                    rs.getString("rua"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("cep"),
                    rs.getString("pais")
            );
        }
        }finally {
            stmt.close();
            rs.close();
        }

        return null;
    }
}
