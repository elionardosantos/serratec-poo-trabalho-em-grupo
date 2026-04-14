package Entity;

import java.time.LocalDate;

public class EntradaDados {

    static void main() {

        Funcionario func1 = new Funcionario("Funcionario1","10326481542", LocalDate.parse("1980-01-01"), 1000.0);
        Funcionario func2 = new Funcionario("Funcionario2","84613468512",LocalDate.parse("1990-01-01"), 5000.0);
        Funcionario func3 = new Funcionario("Funcionario3","74513264857",LocalDate.parse("2000-01-01"), 1000.0);

        Dependente depend1 = new Dependente("Dependente1", "45132546856", LocalDate.parse("2000-01-01"), "FILHO", func3);
        Dependente depend2 = new Dependente("Dependente2", "06451325648", LocalDate.parse("2000-02-01"), "FILHO", func2);
        Dependente depend3 = new Dependente("Dependente3", "49875462315", LocalDate.parse("2000-03-01"), "FILHO", func1);
        Dependente depend4 = new Dependente("Dependente4", "91023152465", LocalDate.parse("2000-04-01"), "FILHO", func1);
        Dependente depend5 = new Dependente("Dependente5", "04587412365", LocalDate.parse("2000-05-01"), "FILHO", func2);

    }

}
