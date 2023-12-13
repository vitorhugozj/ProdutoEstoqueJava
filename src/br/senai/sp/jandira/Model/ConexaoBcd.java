package br.senai.sp.jandira.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBcd {
    private String servidor, banco, user, password;
    public Connection connection;

    public ConexaoBcd() {
        this.servidor = "Localhost";
        this.banco = "db_estoque_produto";
        this.user = "root";
        this.password = "bcd127";

    }

    public void connectDriver() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://" +
                    this.servidor + this.banco + this.user + this.password);
        } catch (SQLException o) {
            System.out.println(o);
        }
    }

    public Connection getConnection() {
        connectDriver();
        return connection;
    }
}
