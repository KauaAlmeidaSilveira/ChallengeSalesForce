package repository;

import model.entities.Conta;
import model.entities.Pagamento;
import model.entities.Servico;
import model.entities.ServicoConta;

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

    public static void listarContas(Repository repository) {
        repository.getContas().forEach(conta -> {
            System.out.println(conta);
            System.out.println(conta.getPessoa());
            System.out.println("\n===");
        });
    }

}
