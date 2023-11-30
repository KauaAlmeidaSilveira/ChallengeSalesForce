package application;

import repository.Repository;
import model.entities.Conta;
import model.entities.Empresa;
import model.entities.Endereco;
import model.entities.Pessoa;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Repository repository = new Repository();

        System.out.println("Bem vindo, somos a SalesForce !!");
        System.out.print("Ja possui uma conta ? (Sim/Não): ");
        String temConta = sc.nextLine();

        while (true) {

            if (temConta.toUpperCase().charAt(0) == 'S') {
                login(repository, sc);
                break;

            } else if (temConta.toUpperCase().charAt(0) == 'N') {
                cadastrar(repository, sc);
                break;

            } else {
                System.out.println("\nDesculpa não entendi.");
                System.out.print("Ja possui uma conta ? (Sim/Não): ");
                temConta = sc.nextLine();
            }
        }

        sc.close();
    }

    private static void menu(Scanner sc, Repository repository) {

        while (true) {
            System.out.println("\nMenu:\n" +
                    "1 - Todos nossos serviços\n" +
                    "2 - Assinar um serviço\n" +
                    "3 - Listar meus serviços\n" +
                    "4 - Histórico de pedidos\n" +
                    "5 - Listar cadastros\n\n" +
                    "6 - Sair");
            System.out.print("Informe o que deseja fazer de acordo com o número das opções: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 6) {
                System.out.print("\nTudo bem, até a próxima! Bye");
                break;
            }

            switch (opcao) {
                case 1:
                    repository.listarTodosServicos(repository);
                    break;

                case 2:
                    repository.assinarServico(repository, sc);
                    break;

                case 3:
                    repository.listarMeusServicos(repository);
                    break;

                case 4:
                    repository.listarMeusPedidos(repository);
                    break;

                case 5:
                    repository.listarCadastros(repository);
                    break;

                default:
                    System.out.print("Opção não reconhecida");
            }
        }
    }

    private static void login(Repository repository, Scanner sc) {


        System.out.println("\n=== Login ===");

        while (true) {

            System.out.print("Digite seu email: ");
            String email = sc.nextLine();

            Conta conta = repository.verificarContaExiste(repository, email);

            if (conta != null) {

                System.out.print("Digite sua senha: ");
                String senha = sc.nextLine();

                if (conta.getSenha().equals(senha)) {
                    repository.setContaAtual(conta);
                    System.out.println("\nLogin realizado com sucesso !!");
                    menu(sc, repository);
                    break;
                } else {
                    while (true) {
                        System.out.print("Digite sua senha novamente: ");
                        senha = sc.nextLine();

                        if (conta.getSenha().equals(senha)) {
                            System.out.println("\nLogin realizado com sucesso !!");
                            menu(sc, repository);
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

        repository.getContas().add(conta);

        System.out.printf("Cadastro realizado com sucesso !!");

        login(repository, sc);

    }

}

