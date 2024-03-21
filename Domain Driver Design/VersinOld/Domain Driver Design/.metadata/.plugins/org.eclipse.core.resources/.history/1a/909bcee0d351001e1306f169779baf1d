package br.com.fiap.main;

import br.com.fiap.beans.Address;
import br.com.fiap.beans.Client;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name = JOptionPane.showInputDialog("Enter client name: ");
        
        String email = JOptionPane.showInputDialog("Enter client email: ");

        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter client age: "));

        double vlrConsult = Double.parseDouble(JOptionPane.showInputDialog("Enter the value of consult: "));
        
        String logradouro = JOptionPane.showInputDialog("Enter your place: ");

        Client client = new Client(name, email, age, vlrConsult, new Address(logradouro));

        System.out.println("INFO CLIENT");

        System.out.println(client.toString());

        sc.close();

    }
}
