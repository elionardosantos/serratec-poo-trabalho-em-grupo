package DAO;

import Entity.Dependente;

import java.sql.*;

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
            System.out.println("Dependente cadastrado com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar dependente: " + e.getMessage());
        }
    }
}