import DAO.ConnectionFactory;
import DAO.FolhaPagamentoDAO;
import Dados.Arquivos;
import Dados.EscreverCsv;
import Dados.LerCsv;
import Entity.FolhaPagamento;
import Entity.Funcionario;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ConnectionFactory factory = new ConnectionFactory(
                "jdbc:postgresql://localhost:5432/folhadepagamento",
                "postgres",
                "1212"
        );
        Connection connection = factory.getConnection();
        FolhaPagamentoDAO folhaPagamentoDAO = new FolhaPagamentoDAO(connection);

        Scanner sc = new Scanner(System.in);
        String caminho = System.getProperty("user.dir") + "/src/CSV";
        String arquivoEntrada;
        List<Funcionario> funcionarios = null;

        do {
            System.out.println("\n=== Selecione o arquivo de ENTRADA ===");
            arquivoEntrada = Arquivos.listar(caminho);

            if (arquivoEntrada == null) {
                System.out.println("\nNenhum arquivo selecionado. Tente novamente.");

            } else {
                LerCsv ler = new LerCsv(arquivoEntrada);
                funcionarios = ler.lerDados();

                if (funcionarios.isEmpty()) {
                    System.out.println(
                            "O arquivo não possui dados ou não está no formato correto" +
                            "\nTente outro arquivo."
                    );
                    funcionarios = null;

                }

            }

        } while (funcionarios == null);

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

        System.out.println(); // Espaçamento
        folhas.forEach(folhaPagamentoDAO::inserir);

        System.out.print("\nDigite um nome para o arquivo de saída:\n-> ");
        String nomeArquivoSaida = sc.nextLine();

        String arquivoSaida = System.getProperty("user.dir") + "/src/CSV/"+nomeArquivoSaida+"_saida.csv";
        EscreverCsv escrever = new EscreverCsv(arquivoSaida);
        escrever.escreverDados(folhas);

        System.out.println("\nArquivo de saída gerado: " + arquivoSaida);
    }
}