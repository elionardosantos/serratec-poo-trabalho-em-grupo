package Entity;

import java.util.ArrayList;
import java.time.LocalDate;
import Enum.ParentescosEnum;
import Exception.DependenteException;

public class EntradaDados {

    static void main() {
        Funcionario func1 = new Funcionario("Funcionario1","10326481542", LocalDate.parse("1980-01-01"), 1000.0);
        Funcionario func2 = new Funcionario("Funcionario2","84613468512",LocalDate.parse("1990-01-01"), 5000.0);
        Funcionario func3 = new Funcionario("Funcionario3","74513264857",LocalDate.parse("2000-01-01"), 1000.0);

        ArrayList<Dependente> dependentes = new ArrayList<>();

//Problema de codigo: muita repeticao de for, talvez criar metodo pra adicionardependente

    try {
        Dependente depend1 = new Dependente("Dependente1", "45132546856", LocalDate.parse("2005-01-01"), ParentescosEnum.FILHO);

        for (Dependente dep : dependentes) {
            if(dep.getCpf().equals(depend1.getCpf())) {
                throw new DependenteException("Nao pode repetir cpf!");
            }
        }
        dependentes.add(depend1);
        Dependente depend2 = new Dependente("Dependente2", "06451325648", LocalDate.parse("2005-02-01"), ParentescosEnum.FILHO);
        for (Dependente dep : dependentes) {
            if(dep.getCpf().equals(depend1.getCpf())) {
                throw new DependenteException("Nao pode repetir cpf!");
            }
        }
        dependentes.add(depend2);
        Dependente depend3 = new Dependente("Dependente3", "49875462315", LocalDate.parse("2005-03-01"), ParentescosEnum.FILHO);
        for (Dependente dep : dependentes) {
            if(dep.getCpf().equals(depend1.getCpf())) {
                throw new DependenteException("Nao pode repetir cpf!");
            }
        }
        dependentes.add(depend3);
        Dependente depend4 = new Dependente("Dependente4", "91023152465", LocalDate.parse("2005-04-01"), ParentescosEnum.FILHO);
        for (Dependente dep : dependentes) {
            if(dep.getCpf().equals(depend1.getCpf())) {
                throw new DependenteException("Nao pode repetir cpf!");
            }
        }
        dependentes.add(depend4);
        Dependente depend5 = new Dependente("Dependente5", "04587412365", LocalDate.parse("2005-05-01"), ParentescosEnum.FILHO);
        for (Dependente dep : dependentes) {
            if(dep.getCpf().equals(depend1.getCpf())) {
                throw new DependenteException("Nao pode repetir cpf!");
            }
        }
        dependentes.add(depend5);
    } catch (DependenteException e) {
        System.out.println(e.getMessage());
    }
    }

}
