package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Connection.ConnectionFactory;
import model.entities.Endereco;

public class EnderecoDAO {

    private Connection myConnection;

    public EnderecoDAO() throws ClassNotFoundException, SQLException {
        this.myConnection = new ConnectionFactory().getConnection();
    }

    public void insert(Endereco endereco) throws SQLException {

        PreparedStatement stmt = myConnection.prepareStatement(
                "insert into tb_endereco (rua, cidade, estado, cep, pais) values (?, ?, ?, ?, ?)"
        );

        stmt.setString(1, endereco.getRua());
        stmt.setString(2, endereco.getCidade());
        stmt.setString(4, endereco.getEstado());
        stmt.setString(5, endereco.getCep());
        stmt.setString(6, endereco.getPais());

        stmt.execute();
        stmt.close();

//        return "Endereço inserido com sucesso!";
    }


}
