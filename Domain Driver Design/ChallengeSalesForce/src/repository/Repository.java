package repository;

import model.entities.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Repository {

    private List<Pessoa> pessoas = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();
    private List<Empresa> empresas = new ArrayList<>();
    private List<Conta> contas = new ArrayList<>();
    private List<Pagamento> pagamentos = new ArrayList<>();
    private List<Servico> servicos = new ArrayList<>();
    private List<ServicoConta> servicoContas = new ArrayList<>();

    private Conta contaAtual = null;

    public Repository() {
        // Pagamentos TESTE
        Pagamento pag01 = new Pagamento(LocalDateTime.now(), 1000.0, "Débito", 2, "pag servico ia");
        Pagamento pag02 = new Pagamento(LocalDateTime.now(), 1500.0, "Credito", 2, "pag servico Sales");
        pagamentos.addAll(List.of(pag01, pag02));

        // Serviços TESTE
        servicos.add(new Servico(1, "IA Eistein", "Servico de IA", "IA", pag01));
        servicos.add(new Servico(2, "Sales", "Servico de Sales", "Sales", pag02));

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

    public Conta verificarContaExiste(Repository repository, String email) {
        for (Conta conta : repository.getContas()) {
            if (conta.getEmail().equals(email)) {
                return conta;
            }
        }
        return null;
    }

    public void assinarServico(Repository repository, Scanner sc){
        System.out.print("Digite o nome do serviço que deseja assinar: ");
        String servico = sc.nextLine();

        servicos.forEach(itemServico -> {
            if(itemServico.getNome().toUpperCase().trim().equals(servico.toUpperCase().trim())){
                ServicoConta servicoConta = new ServicoConta(1, itemServico, contaAtual, LocalDateTime.now());
                servicoContas.add(servicoConta);
            }
        });

        System.out.println("Serviço adicionado com sucesso !!");

    }

    public void listarTodosServicos(){
        servicos.forEach(servico -> {
            System.out.println("=================");
            System.out.println(servico);
        });
    }

    public void listarMeusServicos(Repository repository){
        servicoContas.forEach(servicoConta -> {
            if(servicoConta.getConta() == contaAtual){
                System.out.println(servicoConta);
            }
        });
    }

}
