import Dados.LerCsv;
import Entity.FolhaPagamento;
import Entity.Funcionario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        LerCsv ler = new LerCsv("src/Dados/dados.csv");
        List<Funcionario> funcionarios = ler.lerDados();

        List<FolhaPagamento> folhas = new ArrayList<>();
        int codigo = 1;

        for (Funcionario funcionario : funcionarios){
            folhas.add(new FolhaPagamento(
               codigo++,
               funcionario,
               LocalDate.now(),
               funcionario.getDescontoInss(),
               funcionario.getDescontoIr(),
               funcionario.getSalarioLiquido()
            ));
        }

        for (FolhaPagamento folhaPagamento : folhas){
            System.out.println(folhaPagamento);
        }

//        System.out.println("\n===== FUNCIONÁRIOS E DEPENDENTES =====");
//        for (Funcionario funcionario : funcionarios) {
//            System.out.println("\n" + funcionario);
//        }
    }
}