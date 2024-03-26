package dao;

import model.entities.Servico;
import model.entities.ServicoConta;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PrincipalDAO {

    private final ContaDAO contaDAO = new ContaDAO();
    private final EmpresaDAO empresaDAO = new EmpresaDAO();
    private final EnderecoDAO enderecoDAO = new EnderecoDAO();
    private final PessoaDAO pessoaDAO = new PessoaDAO();
    private final ServicoDAO servicoDAO = new ServicoDAO();
    private final ServicoContaDAO servicoContaDAO = new ServicoContaDAO();

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

    public ServicoDAO getServicoDAO() {
        return servicoDAO;
    }

    public ServicoContaDAO getServicoContaDAO() {
        return servicoContaDAO;
    }

    public void findAllServicos() throws SQLException {
        if (servicoDAO.findAll().isEmpty()) {
            System.out.println("Não há serviços disponíveis no momento.");
        } else {
            System.out.println("Nossos serviços: \n");
            servicoDAO.findAll().forEach(System.out::println);
        }
    }

    public void assinarServico(Scanner sc, Integer idConta) throws SQLException {
        System.out.println("Nossos serviços: \n");

        if (servicoDAO.findAll().isEmpty()) {
            System.out.println("Não há serviços disponíveis no momento.");
        } else {
            servicoDAO.findAll().forEach(System.out::println);

            System.out.print("\nDigite o id do serviço que deseja assinar: ");
            int idServico = sc.nextInt();

            servicoContaDAO.insert(new ServicoConta(idServico, idConta, LocalDate.now().toString()));

            System.out.println("Servico assinado com sucesso !!");
        }
    }

    public void listarCadastros() throws SQLException {
        System.out.println("Listar cadastros: ");
        contaDAO.findAll().forEach(System.out::println);
    }

    public void listarServicos(Integer idConta) throws SQLException, ClassNotFoundException {
        List<Servico> servicos = servicoContaDAO.getMyServices(idConta);
        System.out.println("Seus serviços: \n");

        if (servicos.isEmpty()) {
            System.out.println("Você não possui serviços disponíveis no momento.");
        } else {
            servicos.forEach(System.out::println);
        }
    }

}
