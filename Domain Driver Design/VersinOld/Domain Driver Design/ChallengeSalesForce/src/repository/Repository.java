package repository;

import model.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repository {

    private List<Pessoa> pessoas = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();
    private List<Empresa> empresas = new ArrayList<>();
    private List<Conta> contas = new ArrayList<>();
    private List<Pagamento> pagamentos = new ArrayList<>();
    private List<Servico> servicos = new ArrayList<>();
    private List<ServicoConta> servicoContas = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();

    private Conta contaAtual = null;

    public Repository() {
        // Serviços TESTE
        servicos.add(new Servico(1, "IA Eistein", "Servico de IA", "IA", 15800.00));
        servicos.add(new Servico(2, "Sales", "Servico de Sales", "Sales", 23000.00));

        // Endereço TESTE
        Endereco endereco01 = new Endereco("br");
        Endereco endereco02 = new Endereco("EUA");
        enderecos.addAll(List.of(endereco01, endereco02));

        // Empresa TESTE
        Empresa empresa = new Empresa("Drummond");
        empresas.add(empresa);

        // Pessoa TESTE
        Pessoa p1 = new Pessoa("kaua", "kiwi", null, "(11) 96368-9880", "58.425.456-0", "ti", empresa, endereco01);
        Pessoa p2 = new Pessoa("nary", "nary", null, "(11) 95864-9880", "45.425.365-0", "design", empresa, endereco02);
        pessoas.addAll(List.of(p1, p2));

        // Conta TESTE
        Conta conta01 = new Conta(1, "kaua@", "2011", p1);
        Conta conta02 = new Conta(2, "nary@", "1807", p2);
        contas.addAll(List.of(conta01, conta02));

    }

    public List<Conta> getContas() {
        return contas;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public List<ServicoConta> getServicoContas() {
        return servicoContas;
    }

    public Conta getContaAtual() {
        return contaAtual;
    }

    public void setContaAtual(Conta contaAtual) {
        this.contaAtual = contaAtual;
    }

    public void listarCadastros(Repository repository){
        repository.contas.forEach(System.out::println);
    }

    public Conta verificarContaExiste(Repository repository, String email) {
        for (Conta conta : repository.getContas()) {
            if (conta.getEmail().toUpperCase().trim().equals(email.toUpperCase().trim())) {
                return conta;
            }
        }
        return null;
    }

    public Servico verificarServicoExiste(Repository repository, String nomeServico) {
        for (Servico servico : repository.servicos) {
            if (servico.getNome().toUpperCase().trim().equals(nomeServico.toUpperCase().trim())) {
                return servico;
            }
        }
        return null;
    }

    public void assinarServico(Repository repository, Scanner sc) {
        System.out.println("Todos serviços: ");
        listarTodosServicos(repository);

        System.out.print("\nDigite o nome do serviço que deseja assinar: ");
        String nomeServico = sc.nextLine();

        Servico servico = verificarServicoExiste(repository, nomeServico);

        if (servico != null) {
            System.out.print("Certo, qual metodo de pagamento ? ");
            String metodo = sc.nextLine();

            System.out.print("Deseja parcelar ? (Sim/Não): ");
            String desejaParcelar = sc.nextLine();
            int parcela = 0;

            if (desejaParcelar.toUpperCase().trim().charAt(0) == 'S') {
                System.out.print("Em quantas vezes: ");
                parcela = sc.nextInt();
            }else {
                parcela = 1;
            }

            ServicoConta servicoConta = new ServicoConta(1, servico, contaAtual);
            servicoContas.add(servicoConta);

            Pagamento pagamento = new Pagamento(servico.getValor(), metodo, parcela, servico.getNome());
            pagamentos.add(pagamento);

            Pedido pedido = new Pedido(1, contaAtual, servico, pagamento);
            pedidos.add(pedido);

            System.out.println("Serviço assinado com sucesso, aproveite !!");
        }else {
            System.out.println("Desculpa não encontrei esse serviço, atente-se ao nome !!");
        }

    }

    public void listarMeusPedidos(Repository repository){
        repository.pedidos.forEach(pedido -> {
            if(pedido.getConta() == contaAtual){
                System.out.println(pedido);
            }
        });
    }

    public void listarTodosServicos(Repository repository) {
        repository.servicos.forEach(servico -> {
            System.out.println("=================");
            System.out.println(servico);
        });
    }

    public void listarMeusServicos(Repository repository) {
        repository.servicoContas.forEach(servicoConta -> {
            if (servicoConta.getConta() == contaAtual) {
                System.out.println(servicoConta);
            }
        });
    }

}
