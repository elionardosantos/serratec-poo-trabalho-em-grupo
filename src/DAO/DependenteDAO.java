package DAO;

import Entity.Dependente;
import Entity.Funcionario;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Instanciar um objeto ConnectionFactory e obter a conexão através do método getConnection()
 */
public class DependenteDAO {

    private final Connection connection;

    public DependenteDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Dependente dependente) {

        String sql = "INSERT INTO dependente (id_dependente, nome, cpf, data_nasc, parentesco, titular) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setObject(1, dependente.getId());
            stmt.setString(2, dependente.getNome());
            stmt.setString(3, dependente.getCpf());
            stmt.setDate(4, Date.valueOf(dependente.getDataNascimento()));
            stmt.setString(5, dependente.getParentesco());
            stmt.setObject(6, dependente.getIdFuncionario());
            stmt.execute();
            System.out.println("Dependente cadastrado no banco de dados com sucesso");
        } catch (SQLException exception) {
            System.out.println("Erro ao cadastrar dependente no banco de dados: " + exception.getMessage());
        }
    }
}