package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Connection.ConnectionFactory;
import model.entities.Endereco;

public class EnderecoDAO {

    private final Connection myConnection;

    public EnderecoDAO() throws ClassNotFoundException, SQLException {
        this.myConnection = new ConnectionFactory().getConnection();
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

//        return "Endereço inserido com sucesso!";
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


}
