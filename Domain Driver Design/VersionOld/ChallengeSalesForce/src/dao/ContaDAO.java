package dao;

import model.entities.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    private final Connection myConnection;

    public ContaDAO(Connection connection) throws ClassNotFoundException, SQLException {
        this.myConnection = connection;
    }

    public void insert(Conta conta) throws SQLException, ClassNotFoundException {

        PessoaDAO pessoaDAO = new PessoaDAO(myConnection);

        PreparedStatement stmt = myConnection.prepareStatement(
                "INSERT INTO TB_CONTA (USUARIO, EMAIL, SENHA, DATA_REGISTRO, STATUS, ULTIMO_ACESSO, ID_PESSOA) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)"
        );

        stmt.setString(1, conta.getUsuario());
        stmt.setString(2, conta.getEmail().toLowerCase());
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
            stmt.setString(1, email.toLowerCase());
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

    public Integer getIdByEmail(String email) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = myConnection.prepareStatement("SELECT * FROM TB_CONTA WHERE EMAIL = ?");
            stmt.setString(1, email.toLowerCase());
            rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("ID_CONTA");
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return 0;
    }

    public boolean login(String email, String senha) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = myConnection.prepareStatement(
                    "SELECT * FROM TB_CONTA WHERE EMAIL = ? AND SENHA = ?"
            );
            stmt.setString(1, email.toLowerCase());
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

    public List<Conta> findAll() throws SQLException, ClassNotFoundException {
        PessoaDAO pessoaDAO = new PessoaDAO(myConnection);
        PreparedStatement stmt = myConnection.prepareStatement(
                "SELECT * FROM TB_CONTA"
        );
        ResultSet rs = stmt.executeQuery();

        List<Conta> contas = new ArrayList<>();

        try {
            while (rs.next()) {
                contas.add(new Conta(
                        rs.getInt("ID_CONTA"),
                        rs.getString("USUARIO"),
                        rs.getString("EMAIL"),
                        rs.getString("SENHA"),
                        rs.getString("DATA_REGISTRO"),
                        rs.getString("STATUS"),
                        rs.getString("ULTIMO_ACESSO"),
                        pessoaDAO.findById(rs.getInt("ID_PESSOA"))
                ));
            }

        } finally {
            stmt.close();
            rs.close();
        }

        return contas;
    }

    public Conta findById(Integer id) throws SQLException, ClassNotFoundException {
        PessoaDAO pessoaDAO = new PessoaDAO(myConnection);
        PreparedStatement stmt = myConnection.prepareStatement(
                "SELECT * FROM TB_CONTA WHERE ID_CONTA = ?"
        );

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        try {
            if (rs.next()) {
                return new Conta(
                        rs.getInt("ID_CONTA"),
                        rs.getString("USUARIO"),
                        rs.getString("EMAIL"),
                        rs.getString("SENHA"),
                        rs.getString("STATUS"),
                        rs.getString("DATA_REGISTRO"),
                        rs.getString("ULTIMO_ACESSO"),
                        pessoaDAO.findById(rs.getInt("ID_PESSOA"))
                );
            }
        } finally {
            stmt.close();
            rs.close();
        }

        return null;
    }

}
