package br.senai.sp.jandira.Controller;

import br.senai.sp.jandira.Model.Clientes;
import br.senai.sp.jandira.Model.ConexaoBcd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ClienteController {

    ConexaoBcd conexaoBcd = new ConexaoBcd();

    Connection connection = conexaoBcd.getConnection();

    public void listarCliente() throws SQLException {

        Statement statement = connection.createStatement();
        String queryList = "SELECT * FROM clientes";

        ResultSet resultSet = statement.executeQuery(queryList);

        Clientes cliente = new Clientes();

        while (resultSet.next()) {
            cliente.setCpfCliente(resultSet.getInt("id_cliente"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setCpf(resultSet.getInt("cpf"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setTelefone(resultSet.getInt("telefone"));

            System.out.println("ID Cliente: " + cliente.getCpfCliente());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("/-----------------------------------------------------/");
        }

    }

    public void deletarCliente(int cpf) throws SQLException {
        Statement statement = connection.createStatement();

        String queryDelete = "DELETE FROM clientes WHERE cpf=" + cpf;

        statement.executeUpdate(queryDelete);
        System.out.println("Cliente com CPF " + cpf + " deletado com sucesso!!");

    }

    public void cadastrarCliente(Clientes cliente) throws SQLException {

        Statement statement = connection.createStatement();

        String queryCadastro = "INSERT INTO clientes (id_cliente, nome, cpf, email, telefone) values (" +
                cliente.getCpfCliente() + ",'" + cliente.getNome() + "'," + cliente.getCpf() + ",'" +
                cliente.getEmail() + "'," + cliente.getTelefone() + ")";

        statement.executeUpdate(queryCadastro);
        System.out.println("Cliente cadastrado com sucesso!!");

    }

    public void consultarCliente(int cpf) throws SQLException {
        Statement statement = connection.createStatement();

        String queryConsulta = "SELECT * FROM clientes WHERE cpf=" + cpf;

        ResultSet resultSet = statement.executeQuery(queryConsulta);

        List<Clientes> listConsulta = new ArrayList<>();

        while (resultSet.next()) {
            Clientes cliente = new Clientes();

            cliente.setCpfCliente(resultSet.getInt("id_cliente"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setCpf(resultSet.getInt("cpf"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setTelefone(resultSet.getInt("telefone"));

            listConsulta.add(cliente);
        }

        for (Clientes cliente : listConsulta) {
            System.out.println(cliente.getCpfCliente());
            System.out.println(cliente.getNome());
            System.out.println(cliente.getCpf());
            System.out.println(cliente.getEmail());
            System.out.println(cliente.getTelefone());
            System.out.println("/--------------------------------/");

        }
    }
}