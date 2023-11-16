package application;

import Repository.Repository;
import model.Entity.Cadastro.Conta;
import model.Entity.Cadastro.Empresa;
import model.Entity.Cadastro.Endereco;
import model.Entity.Cadastro.Pessoa;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Repository repository = new Repository();

        System.out.println("Olá, tudo bem ?");
        System.out.print("Deseja acessar o menu da SalesForce ? (Sim/Não): ");
        String acessarMenu = sc.nextLine();

        while (true) {

            if (acessarMenu.toUpperCase().charAt(0) == 'S') {
                menu(sc, repository);
                break;

            } else if (acessarMenu.toUpperCase().charAt(0) == 'N') {
                System.out.println("\nTudo bem, até a proxima! Bye");
                break;

            } else {
                System.out.println("Desculpa não entendi.");
                System.out.print("Deseja acessar o menu da SalesForce ? (Sim/Não): ");
                acessarMenu = sc.nextLine();
            }
        }

        sc.close();
    }

    private static void menu(Scanner sc, Repository repository) {
        while (true) {
            System.out.println("\nMenu:\n" +
                    "1 - Cadastrar\n" +
                    "2 - Listar todos os cadastros\n" +
                    "3 - Sair");
            System.out.print("Informe o que deseja fazer de acordo com o número das opções: ");
            int opcao = sc.nextInt();

            if (opcao == 3) {
                System.out.println("\nTudo bem, até a próxima! Bye");
                break;
            }

            switch (opcao) {
                case 1:
                    cadastrar(repository, sc);
                    break;

                case 2:
                    listarContas(repository);
                    break;

                default:
                    System.out.println("Opção não reconhecida");
            }
        }
    }

    private static void cadastrar(Repository repository, Scanner sc) {

        System.out.println("Certo, vou te fazer algumas perguntas sobre seus dados !!");

        sc.nextLine();

        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite seu cargo: ");
        String cargo = sc.nextLine();

        System.out.println("Digite seu email: ");
        String email = sc.nextLine();

        System.out.println("Digite seu telefone: ");
        String telefone = sc.nextLine();

        System.out.println("Digite sua empresa: ");
        String nomeEmpresa = sc.nextLine();

        System.out.println("Digite seu pais: ");
        String pais = sc.nextLine();

        Empresa empresa = new Empresa(nomeEmpresa);

        Endereco endereco = new Endereco(pais);

        Pessoa pessoa = new Pessoa(nome, telefone, cargo, empresa, endereco);

        Conta conta = new Conta(1, email, pessoa);

        repository.addConta(conta);

    }

    private static void listarContas(Repository repository) {
        repository.getContas().forEach(conta -> {
            System.out.println(conta);
            System.out.println(conta.getPessoa());
        });
    }


}
