package DAO;

import Entity.FolhaPagamento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FolhaPagamentoDAO {

    private final Connection connection;

    public FolhaPagamentoDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(FolhaPagamento folha){
        String sql = "INSERT INTO folha_pagamento (id_folha, codigo, id_funcionario, data_pagamento, desconto_inss, desconto_ir, salario_liquido) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setObject(1, folha.getId());
            stmt.setInt(2, folha.getCodigo());
            stmt.setObject(3, folha.getFuncionario().getId());
            stmt.setDate(4, Date.valueOf(folha.getDataPagamento()));
            stmt.setDouble(5, folha.getDescontoINSS());
            stmt.setDouble(6, folha.getDescontoIR());
            stmt.setDouble(7, folha.getSalarioLiquido());

            stmt.executeUpdate();
            System.out.println("Folha de pagamento de " + folha.getFuncionario().getNome() + " cadastrado no banco de dados com sucesso");
        } catch (SQLException exception) {
            System.out.println("Erro ao cadastrar folha de pagamento no banco de dados: " + exception.getMessage());
        }
    }
}