package Dados;

import Entity.Dependente;
import Entity.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
                                funcionarioAtual);

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
            return funcionarios;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
