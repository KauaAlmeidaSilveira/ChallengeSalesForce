package dao;

import Connection.ConnectionFactory;
import model.entities.Conta;

import java.sql.*;
import java.time.ZoneId;

public class ContaDAO {

    public final Connection myConnection;

    public ContaDAO() throws ClassNotFoundException, SQLException {
        this.myConnection = new ConnectionFactory().getConnection();
    }

    public void insert(Conta conta) throws SQLException {
        PreparedStatement stmt = myConnection.prepareStatement(
                "INSERT INTO TB_CONTA (ID, USUARIO, EMAIL, SENHA, DATA_REGISTRO, STATUS, ULTIMO_ACESSO, ID_PESSOA) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
        );

        stmt.setInt(1, conta.getId());
        stmt.setString(2, conta.getUsuario());
        stmt.setString(3, conta.getEmail());
        stmt.setString(4, conta.getSenha());
        stmt.setString(5, conta.getDataRegistro());
        stmt.setString(6, conta.getStatus());
        stmt.setString(7, conta.getUltimoAcesso());
        stmt.setInt(8, conta.getPessoa().getId());

        stmt.execute();
        stmt.close();

//        return "Conta inserida com sucesso!";
    }

    public boolean verificarContaExiste(String email) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean contaExiste = false;

        try {
            stmt = myConnection.prepareStatement("SELECT * FROM TB_CONTA WHERE EMAIL = ?");
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            // Se houver pelo menos uma linha no resultado, a conta existe
            if (rs.next()) {
                return true;
            }
        } finally {
            // Certifique-se de fechar os recursos
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return false;
    }

    public boolean login(String email, String senha) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = myConnection.prepareStatement(
                    "SELECT * FROM TB_CONTA WHERE EMAIL = ? AND SENHA = ?"
            );
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            // Se houver pelo menos uma linha no resultado, o login foi bem-sucedido
            if (rs.next()) {
                return true;
            }
        } finally {
            // Certifique-se de fechar os recursos
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return false;
    }

}
