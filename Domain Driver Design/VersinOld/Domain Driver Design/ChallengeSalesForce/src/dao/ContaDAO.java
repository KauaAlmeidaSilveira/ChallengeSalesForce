package dao;

import connections.ConnectionFactory;
import model.entities.Conta;

import java.sql.*;

public class ContaDAO {

    public final Connection myConnection;

    private final PessoaDAO pessoaDAO = new PessoaDAO();

    public ContaDAO() throws ClassNotFoundException, SQLException {
        this.myConnection = new ConnectionFactory().getConnection();
    }

    public void insert(Conta conta) throws SQLException {
        PreparedStatement stmt = myConnection.prepareStatement(
                "INSERT INTO TB_CONTA (USUARIO, EMAIL, SENHA, DATA_REGISTRO, STATUS, ULTIMO_ACESSO, ID_PESSOA) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)"
        );

        stmt.setString(1, conta.getUsuario());
        stmt.setString(2, conta.getEmail());
        stmt.setString(3, conta.getSenha());
        stmt.setString(4, conta.getDataRegistro());
        stmt.setString(5, conta.getStatus());
        stmt.setString(6, conta.getUltimoAcesso());
        stmt.setInt(7, pessoaDAO.getId(conta.getPessoa()));

        stmt.execute();
        stmt.close();
    }

    public boolean verificarContaExiste(String email) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = myConnection.prepareStatement("SELECT * FROM TB_CONTA WHERE EMAIL = ?");
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }
        } finally {
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

            if (rs.next()) {
                return true;
            }
        } finally {
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
