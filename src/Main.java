import Dados.Arquivos;
import Dados.EscreverCsv;
import Dados.LerCsv;
import Entity.FolhaPagamento;
import Entity.Funcionario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Caminho atual: " + System.getProperty("user.dir"));

        String caminho = System.getProperty("user.dir") + "/src/Dados";

        System.out.println("=== Selecione o arquivo de ENTRADA ===");
        String arquivoEntrada = Arquivos.listar(caminho);

        if (arquivoEntrada == null) {
            System.out.println("Nenhum arquivo selecionado. Encerrando.");
            return;
        }

        LerCsv ler = new LerCsv(arquivoEntrada);
        List<Funcionario> funcionarios = ler.lerDados();

        List<FolhaPagamento> folhas = new ArrayList<>();
        int codigo = 1;

        for (Funcionario funcionario : funcionarios) {
            folhas.add(new FolhaPagamento(
                    codigo++,
                    funcionario,
                    LocalDate.now(),
                    funcionario.getDescontoInss(),
                    funcionario.getDescontoIr(),
                    funcionario.getSalarioLiquido()
            ));
        }

        System.out.println("\n===== FOLHA DE PAGAMENTO =====");
        for (FolhaPagamento folha : folhas) {
            System.out.println(folha);
        }

        String arquivoSaida = System.getProperty("user.dir") + "/src/Dados/saida.csv";
        EscreverCsv escrever = new EscreverCsv(arquivoSaida);
        escrever.escreverDados(folhas);

        System.out.println("\nArquivo de saída gerado: " + arquivoSaida);
    }
}