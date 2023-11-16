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

        System.out.println("Bem vindo, somos a SalesForce !!");
        System.out.print("Deseja acessar nosso menu ? (Sim/Não): ");
        String acessarMenu = sc.nextLine();

        while (true) {

            if (acessarMenu.toUpperCase().charAt(0) == 'S') {
                menu(sc, repository);
                break;

            } else if (acessarMenu.toUpperCase().charAt(0) == 'N') {
                System.out.print("\nTudo bem, até a proxima! Bye");
                break;

            } else {
                System.out.println("\nDesculpa não entendi.");
                System.out.print("Deseja acessar o nosso menu ? (Sim/Não): ");
                acessarMenu = sc.nextLine();
            }
        }

        sc.close();
    }

    private static void menu(Scanner sc, Repository repository) {
        while (true) {
            System.out.println("\nMenu:\n" +
                    "1 - Login\n" +
                    "2 - Cadastrar\n" +
                    "3 - Listar todos os cadastros\n" +
                    "4 - Sair");
            System.out.print("Informe o que deseja fazer de acordo com o número das opções: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 4) {
                System.out.print("\nTudo bem, até a próxima! Bye");
                break;
            }

            switch (opcao) {
                case 1:
                    login(repository, sc);
                    break;

                case 2:
                    cadastrar(repository, sc);
                    break;

                case 3:
                    listarContas(repository);
                    break;

                default:
                    System.out.print("Opção não reconhecida");
            }
        }
    }

    private static void cadastrar(Repository repository, Scanner sc) {

        System.out.println("\nCerto, vou te fazer algumas perguntas sobre seus dados !!");

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite seu cargo: ");
        String cargo = sc.nextLine();

        System.out.print("Digite seu email: ");
        String email = sc.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();

        System.out.print("Digite seu telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Digite sua empresa: ");
        String nomeEmpresa = sc.nextLine();

        System.out.print("Digite seu pais: ");
        String pais = sc.nextLine();

        Empresa empresa = new Empresa(nomeEmpresa);

        Endereco endereco = new Endereco(pais);

        Pessoa pessoa = new Pessoa(nome, telefone, cargo, empresa, endereco);

        Conta conta = new Conta(1, email, senha, pessoa);

        repository.addConta(conta);

    }

    private static void listarContas(Repository repository) {
        repository.getContas().forEach(conta -> {
            System.out.println(conta);
            System.out.println(conta.getPessoa());
            System.out.println("\n===");
        });
    }

    private static void login(Repository repository, Scanner sc) {
        System.out.println("\n=== Login ===");

        while (true) {

            System.out.print("Digite seu email: ");
            String email = sc.nextLine();

            Conta conta = null;

            for (Conta item : repository.getContas()) {
                if (item.getEmail().equals(email)) {
                    conta = item;
                }
            }

            if (conta != null) {

                System.out.print("Digite sua senha: ");
                String senha = sc.nextLine();

                if (conta.getSenha().equals(senha)) {
                    System.out.println("\nLogin realizado com sucesso !!");
                    break;
                } else {
                    while (true) {
                        System.out.print("Digite sua senha novamente: ");
                        senha = sc.nextLine();

                        if (conta.getSenha().equals(senha)) {
                            System.out.println("\nLogin realizado com sucesso !!");
                            break;
                        }
                    }
                    break;
                }

            } else {
                System.out.println("\nCadastro não encontrado. Tente novamente !");
            }
        }
    }

}
