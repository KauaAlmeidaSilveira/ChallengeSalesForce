package dao;

import connections.ConnectionFactory;
import model.entities.Pagamento;
import model.entities.Pedido;
import model.entities.Servico;
import model.entities.ServicoConta;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PrincipalDAO {

    private final Connection myConnection = new ConnectionFactory().getConnection();

    private final ContaDAO contaDAO = new ContaDAO(myConnection);
    private final EmpresaDAO empresaDAO = new EmpresaDAO(myConnection);
    private final EnderecoDAO enderecoDAO = new EnderecoDAO(myConnection);
    private final PessoaDAO pessoaDAO = new PessoaDAO(myConnection);
    private final ServicoDAO servicoDAO = new ServicoDAO(myConnection);
    private final ServicoContaDAO servicoContaDAO = new ServicoContaDAO(myConnection);
    private final PedidoDAO pedidoDAO = new PedidoDAO(myConnection);
    private final PagamentoDAO pagamentoDAO = new PagamentoDAO(myConnection);

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

    public PedidoDAO getPedidoDAO() {
        return pedidoDAO;
    }

    public PagamentoDAO getPagamentoDAO() {
        return pagamentoDAO;
    }

    public void inserirDadosBanco() throws SQLException {
        servicoDAO.insert(new Servico("Vendas", "Plataforma de vendas online, auxiliando empresas a gerenciar leads, oportunidades e clientes de forma eficiente e escalavel", "Categoria Vendas", 1000.0));
                servicoDAO.insert(new Servico("Marketing", "O serviÃ§o de marketing da Salesforce capacita empresas a criar, automatizar e analisar campanhas multicanais para alcanÃ§ar e engajar clientes de forma eficaz.", "Categoria  Marketing", 2000.0));
                servicoDAO.insert(new Servico("Slack", "Salesforce Slack integra comunicação e colaboração em equipe, facilitando a troca de informaÃ§Ãµes e a coordenação de projetos de forma eficiente.", "Categoria comunicação/colaboração empresarial", 3000.0));
                servicoDAO.insert(new Servico("Salesforce Einstein Analytics", "Fornece insights preditivos e análises avançadas para ajudar as empresas a tomar decisões mais informadas e impulsionar o crescimento.", "Categoria Análise Preditiva", 600.00));
                servicoDAO.insert(new Servico("Salesforce Commerce Cloud", "Salesforce Commerce Cloud é uma plataforma de comércio digital que permite às empresas criar experiências de compra online personalizadas e escaláveis.", "Categoria Comércio Digital", 450.00));
                servicoDAO.insert(new Servico("Salesforce Service Cloud", "Salesforce Service Cloud permite que as empresas forneçam suporte ao cliente de maneira rápida e personalizada através de vários canais.", "Categoria Suporte ao Cliente", 500.00));
    }

    public void findAllServicos() throws SQLException {
        if (servicoDAO.findAll().isEmpty()) {
                inserirDadosBanco();
        }
        System.out.println("Nossos serviços: \n");
        servicoDAO.findAll().forEach(System.out::println);
    }

    public void assinarServico(Scanner sc, Integer idConta) throws SQLException, ClassNotFoundException {

        System.out.println("Nossos serviços: \n");

        servicoDAO.findAll().forEach(System.out::println);

        System.out.print("\nDigite o id do serviço que deseja assinar: ");
        int idServico = sc.nextInt();

        Servico servico = servicoDAO.findById(idServico);

        if (servico != null) {

            System.out.print("Certo, qual a forma de pagamento ? ");
            String formaPagamento = sc.next();

            System.out.print("Quantas parcelas ? ");
            int parcelas = sc.nextInt();

            Pagamento pagamento = new Pagamento(formaPagamento, parcelas, servico);

            pagamentoDAO.insert(pagamento);

            Pedido pedido = new Pedido(contaDAO.findById(idConta), servico, pagamento);

            pedidoDAO.insert(pedido);

            servicoContaDAO.insert(new ServicoConta(idServico, idConta, LocalDate.now().toString()));
            System.out.println("Servico assinado com sucesso !!");
        } else {
            System.out.println("Serviço não encontrado.");
        }

    }

    public void listarCadastros() throws SQLException, ClassNotFoundException {
        System.out.println("Listar cadastros: ");
        contaDAO.findAll().forEach(System.out::println);
    }

    public void listarMeusServicos(Integer idConta) throws SQLException, ClassNotFoundException {
        List<Servico> servicos = servicoContaDAO.getMyServices(idConta);
        System.out.println("Seus serviços: \n");

        if (servicos.isEmpty()) {
            System.out.println("Você não possui serviços disponíveis no momento.");
        } else {
            servicos.forEach(System.out::println);
        }
    }

    public void listarMeusPedidos(Integer idConta) throws SQLException, ClassNotFoundException {
        System.out.println("Histórico de pedidos: \n");
        pedidoDAO.getMyPedidos(idConta).forEach(System.out::println);
    }
}
