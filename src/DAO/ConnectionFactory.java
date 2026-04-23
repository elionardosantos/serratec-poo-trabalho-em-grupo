package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private Connection connection;
    private String url;
    private String user;
    private String password;

    public ConnectionFactory(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() {
        try {
            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conectado ao banco de dados com sucesso...");
        } catch (SQLException exception) {
            System.out.println("Erro na conexão: " + exception.getMessage());
        }
        return this.connection;
    }
}