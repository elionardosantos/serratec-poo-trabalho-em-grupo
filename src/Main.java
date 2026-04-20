import DAO.ConnectionFactory;
import DAO.FuncionarioDAO;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        ConnectionFactory factory = new ConnectionFactory(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "admin"
        );

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(factory.getConnection());

    }

}
