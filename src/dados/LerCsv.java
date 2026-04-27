package dados;

import dao.ConnectionFactory;
import dao.DependenteDAO;
import dao.FuncionarioDAO;
import entity.Dependente;
import entity.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LerCsv {

    private final String atalho;

    public LerCsv(String atalho) {
        this.atalho = atalho;
    }

    public List<Funcionario> lerDados() {
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Dependente> dependentes = new ArrayList<>();
        Funcionario funcionarioAtual = null;

        try (BufferedReader br = new BufferedReader(new FileReader(atalho))) {
            String linha;
            while ((linha = br.readLine()) != null) {

                if (linha.trim().isEmpty()) {
                    continue;
                }
                String[] dado = linha.split(";");

                if (dado.length < 4) {
                    continue;
                }

                if (dado[3].matches("\\d+\\.\\d+")) {
                    try {
                        Funcionario funcionario = new Funcionario(
                                dado[0].trim(),
                                dado[1].trim(),
                                LocalDate.parse(dado[2].trim()),
                                Double.parseDouble(dado[3].trim()));

                        funcionarios.add(funcionario);
                        funcionarioAtual = funcionario;

                    } catch (Exception e) {
                        System.err.println("Erro " + e.getMessage());
                    }

                } else {
                    if (funcionarioAtual == null) {
                        continue;
                    }

                    try {
                        Dependente dependente = new Dependente(
                                dado[0].trim(),
                                dado[1].trim(),
                                LocalDate.parse(dado[2].trim()),
                                dado[3].trim(),
                                funcionarioAtual.getId());

                        dependentes.add(dependente);
                        funcionarioAtual.addDependente(dependente);

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            for (Funcionario funcionario : funcionarios) {
                funcionario.calculoGeral();
            }

            if (!funcionarios.isEmpty()) {
                ConnectionFactory factory = new ConnectionFactory(
                        "jdbc:postgresql://localhost:5432/<nome_do_bd>",
                        "postgres",
                        "<senha_do_bd>"
                );
                Connection connection = factory.getConnection();
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO(connection);
                DependenteDAO dependenteDAO = new DependenteDAO(connection);
                funcionarios.forEach(funcionarioDAO::inserir);
                dependentes.forEach(dependenteDAO::inserir);
            }
            return funcionarios;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
