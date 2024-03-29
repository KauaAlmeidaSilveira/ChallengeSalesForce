package dao;

import model.entities.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresaDAO {

    private final Connection myConnection;

    public EmpresaDAO(Connection connection) {
        this.myConnection = connection;
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

    public Empresa findById(Integer id) throws SQLException {
        PreparedStatement stmt = myConnection.prepareStatement(
                "SELECT * FROM tb_empresa WHERE id_empresa = ?"
        );

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        try {
            if (rs.next()) {
                return new Empresa(
                        rs.getInt("id_empresa"),
                        rs.getString("nome"),
                        rs.getString("departamento"),
                        rs.getString("divisao"),
                        rs.getInt("num_funcionario"),
                        rs.getString("inicio_jornada"),
                        rs.getString("fim_jornada")
                );
            }
        } finally {
            stmt.close();
            rs.close();
        }

        return null;
    }

}
