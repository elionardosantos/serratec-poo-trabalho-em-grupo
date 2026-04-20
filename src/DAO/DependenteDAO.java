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

    public void inserir(Dependente dependente, int idFuncionario){

        String sql = "INSERT INTO dependente (nome, cpf, data_nasc, parentesco, titular) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, dependente.getNome());
            stmt.setString(2, dependente.getCpf());
            stmt.setDate(3, Date.valueOf(dependente.getDataNascimento()));
            stmt.setString(4, dependente.getParentesco());
            stmt.setInt(5, idFuncionario);
            stmt.execute();
            System.out.println("Usuário cadastrado com sucesso");
        } catch (SQLException exception) {
            System.out.println("Erro ao inserir usuário no banco de dados: " + exception.getMessage());
        }
    }

    public void inserir(Dependente dependente, Funcionario funcionario){

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(this.connection);

        String sql = "INSERT INTO dependente (nome, cpf, data_nasc, parentesco, titular) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, dependente.getNome());
            stmt.setString(2, dependente.getCpf());
            stmt.setDate(3, Date.valueOf(dependente.getDataNascimento()));
            stmt.setString(4, dependente.getParentesco());
            stmt.setInt(5, funcionarioDAO.consultaId(funcionario));
            stmt.execute();
            System.out.println("Usuário cadastrado com sucesso");
        } catch (SQLException exception) {
            System.out.println("Erro ao inserir usuário no banco de dados: " + exception.getMessage());
        }
    }

}
