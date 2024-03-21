package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import Connection.ConnectionFactory;
import model.entities.Empresa;

public class EmpresaDAO {

    public final Connection myConnection;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public EmpresaDAO() throws ClassNotFoundException, SQLException {
        this.myConnection = new ConnectionFactory().getConnection();
    }

    public void insert(Empresa empresa) throws SQLException {
        PreparedStatement stmt = myConnection.prepareStatement(
                "INSERT INTO TB_EMPRESA (ID, NOME, DEPARTAMENTO, DIVISAO, NUM_FUNCIONARIO, INICIO_JORNADA, FIM_JORNADA) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)"
        );

        stmt.setInt(1, empresa.getId());
        stmt.setString(2, empresa.getNome());
        stmt.setString(3, empresa.getDepartamento());
        stmt.setString(4, empresa.getDivisao());
        stmt.setInt(5, empresa.getNumFuncionario());
        stmt.setString(6 , empresa.getInicioJornada());
        stmt.setString(7,  empresa.getFimJornada());

        stmt.execute();
        stmt.close();

//        return "Empresa inserida com sucesso!";
    }

}
