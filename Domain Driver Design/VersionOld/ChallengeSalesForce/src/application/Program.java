package application;

import dao.PrincipalDAO;
import model.entities.Conta;
import model.entities.Empresa;
import model.entities.Endereco;
import model.entities.Pessoa;

import java.sql.SQLException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        PrincipalDAO principalDAO = new PrincipalDAO();

        System.out.println("Bem vindo, somos a SalesForce !!");
        System.out.print("Ja possui uma conta ? (Sim/Não): ");
        String temConta = sc.nextLine();

        while (true) {

            if (temConta.toUpperCase().charAt(0) == 'S') {
                login(principalDAO, sc);
                break;

            } else if (temConta.toUpperCase().charAt(0) == 'N') {
                cadastrar(sc, principalDAO);
                break;

            } else {
                System.out.println("\nDesculpa não entendi.");
                System.out.print("Ja possui uma conta ? (Sim/Não): ");
                temConta = sc.nextLine();
            }
        }

        sc.close();
    }

    private static void menu(Scanner sc, PrincipalDAO principalDAO, Conta conta) throws SQLException, ClassNotFoundException {

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

            System.out.println("");

            switch (opcao) {
                case 1:
                    principalDAO.findAllServicos();
                    break;

                case 2:
                    principalDAO.assinarServico(sc, conta.getId());
                    break;

                case 3:
                    principalDAO.listarMeusServicos(conta.getId());
                    break;

                case 4:
                    principalDAO.listarPedidos();
                    break;

                case 5:
                    principalDAO.listarCadastros();
                    break;

                default:
                    System.out.print("Opção não reconhecida");
            }
        }
    }

    private static void login(PrincipalDAO principalDAO, Scanner sc) throws SQLException, ClassNotFoundException {
        System.out.println("\n=== Login ===");

        while (true) {

            System.out.print("Digite seu email: ");
            String email = sc.nextLine();

            boolean contaExiste = principalDAO.getContaDAO().verificarContaExiste(email);

            if (contaExiste) {

                System.out.print("Digite sua senha: ");
                String senha = sc.nextLine();

                if (principalDAO.getContaDAO().login(email, senha)) {
                    System.out.println("\nLogin realizado com sucesso !!");
                    menu(sc, principalDAO, new Conta(principalDAO.getContaDAO().getIdByEmail(email), email, senha));
                    break;
                } else {
                    while (true) {
                        System.out.print("Digite sua senha novamente: ");
                        senha = sc.nextLine();

                        if (principalDAO.getContaDAO().login(email, senha)) {
                            System.out.println("\nLogin realizado com sucesso !!");
                            menu(sc, principalDAO, new Conta(principalDAO.getContaDAO().getIdByEmail(email), email, senha));
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

    private static void cadastrar(Scanner sc, PrincipalDAO principalDAO) throws SQLException, ClassNotFoundException {

        System.out.println("\nCerto, vou te fazer algumas perguntas sobre seus dados !!");

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite seu rg: ");
        String rg = sc.nextLine();

        System.out.print("Digite seu email: ");
        String email = sc.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();

        System.out.print("Digite seu celular: ");
        String celular = sc.nextLine();

        System.out.print("Digite o nome da sua empresa: ");
        String nomeEmpresa = sc.nextLine();

        System.out.print("Digite seu cargo: ");
        String cargo = sc.nextLine();

        System.out.print("Digite seu endereço: ");
        String rua = sc.nextLine();

        System.out.print("Digite sua cidade: ");
        String cidade = sc.nextLine();

        System.out.print("Digite seu estado: ");
        String estado = sc.nextLine();

        System.out.print("Digite seu cep: ");
        String cep = sc.nextLine();

        Empresa empresa = new Empresa(nomeEmpresa);

        Endereco endereco = new Endereco(rua, cidade, estado, cep);

        Pessoa pessoa = new Pessoa(nome, celular, cargo, rg, empresa, endereco);

        Conta conta = new Conta(email, senha, pessoa);

        principalDAO.getEmpresaDAO().insert(empresa);

        principalDAO.getEnderecoDAO().insert(endereco);

        principalDAO.getPessoaDAO().insert(pessoa);

        principalDAO.getContaDAO().insert(conta);

        System.out.print("Cadastro realizado com sucesso !!");

        login(principalDAO, sc);

    }

}

