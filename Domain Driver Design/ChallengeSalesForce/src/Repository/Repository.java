package Repository;

import model.Entity.Cadastro.Conta;
import model.Entity.Servico.Pagamento;
import model.Entity.Servico.Servico;
import model.Entity.ServicoConta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    private List<Conta> contas = new ArrayList<>();
    private List<Servico> servicos = new ArrayList<>();
    private List<ServicoConta> servicoContas = new ArrayList<>();


    public Repository() {
        servicos.add(new Servico(1, "IA Eistein", "Servico de IA", "IA", new Pagamento(LocalDateTime.now(), 1000.0, "Débito", 2, "pag servico ia")));
        servicos.add(new Servico(2, "Sales", "Servico de Sales", "Sales", new Pagamento(LocalDateTime.now(), 1500.0, "Credito", 2, "pag servico Sales")));
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

    public void addConta(Conta conta) {
        this.contas.add(conta);
    }

    public void addServico(Servico servico) {
        this.servicos.add(servico);
    }

    public void addServicoConta(ServicoConta servicoConta) {
        this.servicoContas.add(servicoConta);
    }

    public List<Conta> listContas() {
        return this.contas;
    }

    public List<Servico> listServicos() {
        return this.servicos;
    }

    public List<ServicoConta> listServicoContas() {
        return this.servicoContas;
    }

}
