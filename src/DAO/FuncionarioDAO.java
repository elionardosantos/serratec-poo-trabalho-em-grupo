package DAO;

import Entity.Funcionario;

import java.sql.*;
import java.time.LocalDate;

/**
 * Instanciar um objeto ConnectionFactory e obter a conexão através do método getConnection()
 */
public class FuncionarioDAO {

    private final Connection connection;

    public FuncionarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Funcionario funcionario){

        String sql = "INSERT INTO funcionario (nome, cpf, data_nasc, salario_bruto) VALUES (?, ?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setDate(3, Date.valueOf(funcionario.getDataNascimento()));
            stmt.setDouble(4, funcionario.getSalarioBruto());
            stmt.execute();
            System.out.println("Usuário cadastrado com sucesso");
        } catch (SQLException exception) {
            System.out.println("Erro ao inserir usuário no banco de dados: " + exception.getMessage());
        }

    }

    public int consultaId(Funcionario funcionario) {

        int funcionarioId = 0;
        String sql = "SELECT id_funcionario FROM funcionario WHERE cpf = ?";

        try (connection) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getCpf());

            try (ResultSet resultSet = stmt.executeQuery()){

                while (resultSet.next()){
                    funcionarioId = resultSet.getInt("id_funcionario");
                }

            } catch (SQLException exception) {
                System.out.println("Houve um erro ao consultar o ID do funcionario");
            }

        } catch (SQLException exception) {
            System.out.println("Houve um erro ao consultar o ID do funcionario");

        }

        return funcionarioId;
    }

}
