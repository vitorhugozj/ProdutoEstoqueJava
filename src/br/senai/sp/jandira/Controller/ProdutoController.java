package br.senai.sp.jandira.Controller;

import br.senai.sp.jandira.Model.ConexaoBcd;
import br.senai.sp.jandira.Model.Produtos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {

    ConexaoBcd conexaoBcd = new ConexaoBcd();
    Connection connection = conexaoBcd.getConnection();

    public void listaDeProdutos() throws SQLException {

        Statement statement = connection.createStatement();
        String list = "SELECT * FROM produtos";

        ResultSet resultSet = statement.executeQuery(list);

        Produtos produtos = new Produtos();

        while (resultSet.next()) {
            produtos.setNomeProduto(resultSet.getString("nome_produto"));
            produtos.setFornecedor(resultSet.getNString("fornecedor"));
            produtos.setId(resultSet.getInt("id_produto"));
            produtos.setQuantidadeEstoque(resultSet.getInt("quantidade_estoque"));
            produtos.setValor(resultSet.getDouble("valor"));

            System.out.println("ID do Produto: " + produtos.getId());
            System.out.println("Nome do Produto: " + produtos.getNomeProduto());
            System.out.println("Valor do Produto: " + produtos.getValor());
            System.out.println("Fornecedor: " + produtos.getFornecedor());
            System.out.println("Quantidade de Estoque: " + produtos.getQuantidadeEstoque());
        }
    }

    public void alterarProduto(int qtdEstoque, String nomeDoProduto) throws SQLException {
        Statement statement = connection.createStatement();
        String update = "UPDATE produtos SET quantidade_estoque" + qtdEstoque + "WHERE nome_produto = " + nomeDoProduto + "'";

        statement.executeUpdate(update);
        System.out.println("Dados alterados com êxito!!");
    }

    public void cadastrarNovoProduto(Produtos produtos) throws SQLException {
        Statement statement = connection.createStatement();

        String cadastro = "INSERT INTO produtos (id_produto, nome_produto, quantidade_estoque, valor, fornecedor) values (" +
                produtos.getId() + "," + produtos.getNomeProduto() + "," + produtos.getQuantidadeEstoque() + "," +
                produtos.getValor() + "," + produtos.getFornecedor() + ")";

        statement.executeUpdate(cadastro);
        System.out.println("Produto cadastrado com êxito!!");
    }

    public void consultarProduto(String nomeDoProduto) throws SQLException {
        Statement statement = connection.createStatement();

        String consulta = "SELECT * FROM produtos WHERE nome_produto=" + nomeDoProduto + "'";

        ResultSet resultSet = statement.executeQuery(consulta);

        List<Produtos> produtosList = new ArrayList<>();

        while (resultSet.next()) {
            Produtos produtos = new Produtos();

            produtos.setId(resultSet.getInt("id_produto"));
            produtos.setNomeProduto(resultSet.getString("nome_produto"));
            produtos.setQuantidadeEstoque(resultSet.getInt("quantidade_estoque"));
            produtos.setValor(resultSet.getDouble("valor"));
            produtos.setFornecedor(resultSet.getString("fornecedor"));

            produtosList.add(produtos);
        }

        for (Produtos produto : produtosList) {
            System.out.println(produto.getId());
            System.out.println(produto.getNomeProduto());
            System.out.println(produto.getQuantidadeEstoque());
            System.out.println(produto.getValor());
            System.out.println(produto.getFornecedor());
            System.out.println("/--------------------------------/");
        }

    }
}
