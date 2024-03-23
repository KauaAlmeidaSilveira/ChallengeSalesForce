package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connections.ConnectionFactory;
import model.entities.Empresa;

public class EmpresaDAO {

    public final Connection myConnection;

    public EmpresaDAO() throws ClassNotFoundException, SQLException {
        this.myConnection = new ConnectionFactory().getConnection();
    }

    public void insert(Empresa empresa) throws SQLException {
        PreparedStatement stmt = myConnection.prepareStatement(
                "INSERT INTO tb_empresa (nome) VALUES (?)"
        );
        stmt.setString(1, empresa.getNome());

        stmt.execute();
        stmt.close();

//        return "Empresa inserida com sucesso!";
    }

    public Integer getId(Empresa empresa) throws SQLException {
        PreparedStatement stmt = myConnection.prepareStatement(
                "SELECT id_empresa FROM tb_empresa WHERE nome = ?"
        );

        stmt.setString(1, empresa.getNome());

        Integer id = null;
        try {
            var rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_empresa");
            }
        } finally {
            stmt.close();
        }

        return id;
    }

}
