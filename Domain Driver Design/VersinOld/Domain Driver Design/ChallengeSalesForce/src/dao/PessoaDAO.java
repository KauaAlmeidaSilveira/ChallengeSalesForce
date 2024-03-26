package dao;

import connections.ConnectionFactory;
import model.entities.Empresa;
import model.entities.Endereco;
import model.entities.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAO {

    private final Connection myConnection;

    private final EnderecoDAO enderecoDAO = new EnderecoDAO();
    private final EmpresaDAO empresaDAO = new EmpresaDAO();

    public PessoaDAO() throws ClassNotFoundException, SQLException {
        this.myConnection = new ConnectionFactory().getConnection();
    }

    public void insert(Pessoa pessoa) throws SQLException {

        PreparedStatement stmt = myConnection.prepareStatement(
                "INSERT INTO tb_pessoa (nome, celular, cargo, rg, id_endereco, id_empresa) " +
                        "VALUES (?, ?, ?, ?, ?, ?)"
        );

        stmt.setString(1, pessoa.getNome());
        stmt.setString(2, pessoa.getCelular());
        stmt.setString(3, pessoa.getCargo());
        stmt.setString(4, pessoa.getRg());
        stmt.setInt(5, enderecoDAO.getId(pessoa.getEndereco()));
        stmt.setInt(6, empresaDAO.getId(pessoa.getEmpresa()));


        stmt.execute();
        stmt.close();

//        return "Pessoa inserida com sucesso!";
    }

    public Integer getId(Pessoa pessoa) throws SQLException {
        PreparedStatement stmt = myConnection.prepareStatement(
                "SELECT id_pessoa FROM tb_pessoa WHERE nome = ? AND rg = ?"
        );

        stmt.setString(1, pessoa.getNome());
        stmt.setString(2, pessoa.getRg());

        Integer id = null;
        try {
            var rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_pessoa");
            }
        } finally {
            stmt.close();
        }

        return id;
    }

    public Pessoa findById(Integer id) throws SQLException {
        PreparedStatement stmt = myConnection.prepareStatement(
                "SELECT * FROM tb_pessoa WHERE id_pessoa = ?"
        );

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        try {
            if (rs.next()) {
                return new Pessoa(
                        rs.getInt("id_pessoa"),
                        rs.getString("nome"),
                        rs.getString("apelido"),
                        rs.getString("telefone"),
                        rs.getString("celular"),
                        rs.getString("rg"),
                        rs.getString("cargo"),
                        empresaDAO.findById(rs.getInt("id_empresa")),
                        enderecoDAO.findById(rs.getInt("id_endereco"))
                );
            }
        } finally {
            stmt.close();
            rs.close();
        }


        return null;
    }

}
