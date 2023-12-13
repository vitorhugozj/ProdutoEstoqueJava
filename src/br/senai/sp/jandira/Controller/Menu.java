package br.senai.sp.jandira.Controller;

import java.sql.SQLException;
import java.util.Scanner;
public class Menu {

    public void executarMenu() throws SQLException {
        boolean continuar = true;

        while (continuar) {
            System.out.println("/----------- Bem Vindo -----------/");
            System.out.println("-----------------------------------");
            System.out.println("1- Lista de Clientes");
            System.out.println("2- Cadastro de Clientes");
            System.out.println("3- Deletar Cliente");
            System.out.println("4- Pesquisar Cliente");
            System.out.println("5- Lista de Produtos");
            System.out.println("6- Cadastro de Produtos");
            System.out.println("7- Editar Produtos");
            System.out.println("8- Deletar Produtos");
            System.out.println("9- Pesquisar um Produto");
            System.out.println("10- Sair");
            System.out.println("-----------------------------------");

            Scanner scanner = new Scanner(System.in);

            int userOption = scanner.nextInt();
            scanner.nextLine();

            ClienteController clienteController = new ClienteController();
            ProdutoController produtoController = new ProdutoController();


        }
    }
}
