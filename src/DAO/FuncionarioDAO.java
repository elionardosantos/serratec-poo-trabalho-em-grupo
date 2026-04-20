package DAO;

import Entity.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class FuncionarioDAO {

    private Connection connection;
    String nome;
    String cpf;
    LocalDate dataNascimento;
    Double salarioBruto;

    public FuncionarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Funcionario funcionario){

        String sql = "INSERT INTO funcionario(nome, cpf, data_nasc, salario_bruto) VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, funcionario.getNome());
        stmt.setString(2, funcionario.getCpf());
        stmt.setString(3, );
        stmt.setDouble(4, funcionario.get);

    }

}
