package application;

import dao.ContaDAO;
import dao.EmpresaDAO;
import dao.EnderecoDAO;
import dao.PessoaDAO;
import repository.Repository;
import model.entities.Conta;
import model.entities.Empresa;
import model.entities.Endereco;
import model.entities.Pessoa;

import java.sql.SQLException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);

        Repository repository = new Repository();

        System.out.println("Bem vindo, somos a SalesForce !!");
        System.out.print("Ja possui uma conta ? (Sim/Não): ");
        String temConta = sc.nextLine();

        while (true) {

            if (temConta.toUpperCase().charAt(0) == 'S') {
//                login(repository, sc);
                break;

            } else if (temConta.toUpperCase().charAt(0) == 'N') {
                cadastrar(sc);
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

    private static void cadastrar(Scanner sc) throws SQLException, ClassNotFoundException {

        System.out.println("\nCerto, vou te fazer algumas perguntas sobre seus dados !!");

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite seu apelido: ");
        String apelido = sc.nextLine();

        System.out.print("Digite seu cargo: ");
        String cargo = sc.nextLine();

        System.out.print("Digite seu email: ");
        String email = sc.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();

        System.out.print("Digite seu telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Digite seu celular: ");
        String celular = sc.nextLine();

        System.out.print("Digite seu RG: ");
        String RG = sc.nextLine();

        System.out.print("Digite sua empresa: ");
        String nomeEmpresa = sc.nextLine();

        System.out.print("Digite seu endereço: ");
        String rua = sc.nextLine();

        System.out.print("Digite sua cidade: ");
        String cidade = sc.nextLine();

        Empresa empresa = new Empresa(nomeEmpresa);

        Endereco endereco = new Endereco(rua, cidade);

        Pessoa pessoa = new Pessoa(nome, apelido, telefone, celular, RG, cargo, empresa, endereco);

        Conta conta = new Conta( email, senha, pessoa);

        EmpresaDAO empresaDAO = new EmpresaDAO();
        empresaDAO.insert(empresa);

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.insert(endereco);

        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.insert(pessoa);

        ContaDAO contaDAO = new ContaDAO();
        contaDAO.insert(conta);

        System.out.printf("Cadastro realizado com sucesso !!");

//        login(repository, sc);

    }

}

