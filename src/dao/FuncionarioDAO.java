package dao;

import entity.Funcionario;

import java.sql.*;

/**
 * Instanciar um objeto ConnectionFactory e obter a conexão através do método getConnection()
 */
public class FuncionarioDAO {

    private final Connection connection;

    public FuncionarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Funcionario funcionario){

        String sql = "INSERT INTO funcionario (id_funcionario, nome, cpf, data_nasc, salario_bruto) VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setObject(1, funcionario.getId());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCpf());
            stmt.setDate(4, Date.valueOf(funcionario.getDataNascimento()));
            stmt.setDouble(5, funcionario.getSalarioBruto());
            stmt.execute();
            System.out.println("Funcionário "+funcionario.getNome()+" cadastrado no banco de dados com sucesso");

        } catch (SQLException exception) {
            System.out.println("Erro ao cadastrar funcionário no banco de dados: " + exception.getMessage());

        }
    }
}
