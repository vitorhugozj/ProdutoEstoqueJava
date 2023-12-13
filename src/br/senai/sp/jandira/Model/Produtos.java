package br.senai.sp.jandira.Model;

import java.util.Scanner;

public class Produtos {

    private String nomeProduto, fornecedor;
    private int id = 0;
    private int quantidadeEstoque;
    private double valor;

    public void cadastroDeProduto(int idProduto) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome: ");
        this.nomeProduto = scanner.nextLine();
        System.out.println("Informe a quantidade de estoque: ");
        this.quantidadeEstoque = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Informe o valor: ");
        this.valor = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Informe o fornecedor: ");
        this.fornecedor = scanner.nextLine();

    }

    public String getNomeProduto() {
        return this.nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFornecedor() {
        return this.fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
