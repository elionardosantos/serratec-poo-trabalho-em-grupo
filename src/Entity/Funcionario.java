package Entity;

import Exception.DependenteException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Funcionario extends Pessoa {

    private Double salarioBruto;
    private Double salarioLiquido;
    private Double descontoInss;
    private Double descontoIr;

    private List<Dependente> dependentes = new ArrayList<>();
    private Set<String> cpfsDependentes = new HashSet<>();

    public Funcionario(
            String nome,
            String cpf,
            LocalDate dataNascimento,
            Double salarioBruto
    ) {
        super(nome, cpf, dataNascimento);
        this.salarioBruto = salarioBruto;
    }

    public void adicionarDependente(Dependente dependente) {

        if (cpfsDependentes.contains(dependente.getCpf())) {
            throw new DependenteException(
                    "ERRO!!! o CPF de dependente já cadastrado para este funcionário"
            );
        }

        cpfsDependentes.add(dependente.getCpf());
        dependentes.add(dependente);
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }
}