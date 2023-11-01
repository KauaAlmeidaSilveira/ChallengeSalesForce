package main;

import Repository.Repository;
import model.Entity.Cadastro.Conta;
import model.Entity.Cadastro.Empresa;
import model.Entity.Cadastro.Endereco;
import model.Entity.Cadastro.Pessoa;
import model.Entity.Servico.Pagamento;
import model.Entity.Servico.Servico;
import model.Entity.ServicoConta;

import java.time.LocalDateTime;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        // Criação de objetos
        Empresa empresa = new Empresa("UniDrummond", "Ti");
        Endereco endereco = new Endereco("Rua Teste", "São Paulo", "SP", "09999999", "BR");
        Pessoa pessoa = new Pessoa("Kauã", "kiwi", "9999-9999", "+55 (11) 999999999", "55.555.555-5", empresa, endereco);

        Conta conta = new Conta(1, "kaua@gmail.com", "321123", pessoa);
        Pagamento pagamento = new Pagamento(LocalDateTime.now(), 1780.00, "Cartão de débito", 3, "Serviço de IA");

        Servico servico1 = new Servico(1, "IAEinstein", "Serviço de IA", "IA", pagamento);
        Servico servico2 = new Servico(2, "360", "Serviço geral", "Geral", pagamento);
        Servico servico3 = new Servico(3, "Sales", "Serviço de vendas", "Vendas", pagamento);

        Repository repository = new Repository();

        // Adição de objetos ao repositório
        repository.addConta(conta);
        repository.addServico(servico1);
        repository.addServico(servico2);
        repository.addServico(servico3);

        // Criação de objetos ServicoConta e adição ao repositório
        ServicoConta servicoConta1 = new ServicoConta(1, servico1.getId(), conta.getId(), LocalDateTime.now());
        ServicoConta servicoConta2 = new ServicoConta(2, servico2.getId(), conta.getId(), LocalDateTime.now());
        ServicoConta servicoConta3 = new ServicoConta(3, servico3.getId(), conta.getId(), LocalDateTime.now());

        repository.addServicoConta(servicoConta1);
        repository.addServicoConta(servicoConta2);
        repository.addServicoConta(servicoConta3);

        // Exibição dos ServicoContas
        List<ServicoConta> servicoContas = repository.listServicoContas();
        for (ServicoConta servicoConta : servicoContas) {
            System.out.println(servicoConta);
        }
    }
}
