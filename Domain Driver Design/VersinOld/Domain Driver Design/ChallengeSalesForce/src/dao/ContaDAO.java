package dao;

import Connection.ConnectionFactory;
import model.entities.Conta;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZoneId;

public class ContaDAO {

    public final Connection myConnection;

    public ContaDAO() throws ClassNotFoundException, SQLException {
        this.myConnection = new ConnectionFactory().getConnection();
    }

    public void insert(Conta conta) throws SQLException {
        PreparedStatement stmt = myConnection.prepareStatement(
                "INSERT INTO TB_CONTA (ID, USUARIO, EMAIL, SENHA, DATA_REGISTRO, STATUS, ULTIMO_ACESSO, ID_PESSOA) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)"
        );

        stmt.setInt(1, conta.getId());
        stmt.setString(2, conta.getUsuario());
        stmt.setString(3, conta.getEmail());
        stmt.setString(4, conta.getSenha());
        stmt.setString(5, conta.getStatus());
        stmt.setDate(6, Date.valueOf(conta.getDataRegistro()));
        stmt.setDate(7, (Date) Date.from(conta.getUltimoAcesso().atZone(ZoneId.systemDefault()).toInstant()));
        stmt.setInt(8, conta.getPessoa().getId());

        stmt.execute();
        stmt.close();

//        return "Conta inserida com sucesso!";
    }

    public boolean verificarContaExiste(String email) throws SQLException {
        PreparedStatement stmt = myConnection.prepareStatement(
                "SELECT * FROM TB_CONTA WHERE EMAIL = ?"
        );

        stmt.setString(1, email);
        boolean result = stmt.execute();
        stmt.close();
        return result;
    }

    public boolean login(String email, String senha) throws SQLException {
        PreparedStatement stmt = myConnection.prepareStatement(
                "SELECT * FROM TB_CONTA WHERE EMAIL = ? AND SENHA = ?"
        );

        stmt.setString(1, email);
        stmt.setString(2, senha);

        boolean result = stmt.execute();
        stmt.close();
        return result;
    }

}
