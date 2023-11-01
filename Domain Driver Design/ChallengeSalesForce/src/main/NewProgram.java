package main;

import java.util.Scanner;

public class NewProgram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Olá, tudo bem ?");
        System.out.print("Vamos realizar seu cadastro na SalesForce, tudo bem ? (Sim/Não): ");
        String realizarCadastro = sc.next();

        if (realizarCadastro.toUpperCase().charAt(0) == 'S') {

            while (true) {

                System.out.println("\nMenu:\n" +
                        "1 - Cadastrar\n" +
                        "2 - Listar todos os cadastros\n" +
                        "3 - Sair");
                System.out.print("Informe o que deseja fazer de acordo com o numero das opções: ");
                int opcao = sc.nextInt();

                if (opcao == 3){
                    System.out.println("\nTudo bem, até a proxima! Bye");
                    break;
                }

                switch (opcao) {
                    case 1:
                        System.out.println("Entrou em Cadastrar");
                        System.out.println("Saiu de Cadastrar");
                        break;

                    case 2:
                        System.out.println("Entrou em Listar todos os cadastros");
                        System.out.println("Saiu de Listar");
                        break;

                    default:
                        System.out.println("Opção não reconhecida");
                }
            }
        } else {
            System.out.println("\nTudo bem, até a proxima! Bye");
        }
        sc.close();
    }
}
