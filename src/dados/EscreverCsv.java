package dados;

import entity.FolhaPagamento;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscreverCsv {

    private final String atalho;

    public EscreverCsv(String atalho) {
        this.atalho = atalho;
    }

    public void escreverDados(List<FolhaPagamento> folhas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(atalho))) {
            for (FolhaPagamento folha : folhas) {
                bw.write(folha.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever arquivo de saída: " + e.getMessage());
        }
    }
}