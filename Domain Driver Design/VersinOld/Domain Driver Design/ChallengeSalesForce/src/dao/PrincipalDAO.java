package dao;

import java.sql.SQLException;

public class  PrincipalDAO {

    private final ContaDAO contaDAO = new ContaDAO();
    private final EmpresaDAO empresaDAO = new EmpresaDAO();
    private final EnderecoDAO enderecoDAO = new EnderecoDAO();
    private final PessoaDAO pessoaDAO = new PessoaDAO();


    public PrincipalDAO() throws SQLException, ClassNotFoundException {
    }

    public ContaDAO getContaDAO() {
        return contaDAO;
    }

    public EmpresaDAO getEmpresaDAO() {
        return empresaDAO;
    }

    public EnderecoDAO getEnderecoDAO() {
        return enderecoDAO;
    }

    public PessoaDAO getPessoaDAO() {
        return pessoaDAO;
    }
}
