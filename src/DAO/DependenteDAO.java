package DAO;

import Entity.Dependente;
import Entity.Funcionario;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
            System.out.println("Dependente "+dependente.getNome()+" cadastrado no banco de dados com sucesso");
        } catch (SQLException exception) {
            System.out.println("Erro ao cadastrar dependente no banco de dados: " + exception.getMessage());
        }
    }


    public List<Dependente> listarTodos() {

        String sql = "SELECT * FROM dependente";
        List<Dependente> dependentes = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Dependente dependente = new Dependente(
                        (UUID) resultSet.getObject("id_dependente"),
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
                        LocalDate.parse(resultSet.getDate("data_nasc").toString()),
                        resultSet.getString("parentesco"),
                        (UUID) resultSet.getObject("titular")
                );

                dependentes.add(dependente);
            }

        } catch (SQLException exception) {
            System.out.println("Houve um erro ao consultar os dependentes no banco de dados: " + exception.getMessage());
        }
        return dependentes;
    }
}