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

    public void inserir(FolhaPagamento folha) throws SQLException {
        String sql = "INSERT INTO folha_pagamento (codigo, id_funcionario, data_pagamento, desconto_inss, desconto_ir, salario_liquido) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, folha.getCodigo());
            stmt.setObject(2, folha.getFuncionario().getId());
            stmt.setDate(3, Date.valueOf(folha.getDataPagamento()));
            stmt.setDouble(4, folha.getDescontoINSS());
            stmt.setDouble(5, folha.getDescontoIR());
            stmt.setDouble(6, folha.getSalarioLiquido());

            stmt.executeUpdate();
            System.out.println("Folha de pagamento inserida para: " + folha.getFuncionario().getNome());
        }
    }
}