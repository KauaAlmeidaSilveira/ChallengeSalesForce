package dao;

import Connection.ConnectionFactory;
import model.entities.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public  class  PessoaDAO {

    private final Connection myConnection;

    public PessoaDAO() throws ClassNotFoundException, SQLException {
        this.myConnection = new ConnectionFactory().getConnection();
    }

    public void insert(Pessoa pessoa) throws SQLException {

        PreparedStatement stmt = myConnection.prepareStatement(
                "insert into tb_pessoa (id, nome, apelido, telefone, celular, RG, cargo, empresa_id, endereco_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?)"
        );

        stmt.setInt(1, pessoa.getId());
        stmt.setString(2, pessoa.getNome());
        stmt.setString(3, pessoa.getApelido());
        stmt.setString(4, pessoa.getTelefone());
        stmt.setString(5, pessoa.getCelular());
        stmt.setString(6, pessoa.getRG());
        stmt.setString(7, pessoa.getCargo());
        stmt.setInt(8, pessoa.getEmpresa().getId());
        stmt.setInt(9, pessoa.getEndereco().getId());

        stmt.execute();
        stmt.close();

//        return "Pessoa inserida com sucesso!";
    }

}
