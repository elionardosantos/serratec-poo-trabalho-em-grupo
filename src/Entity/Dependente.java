package Entity;

import Exception.DependenteException;
import Enum.ParentescosEnum;

import java.time.LocalDate;
import java.time.Period;

public class Dependente extends Pessoa {

    private ParentescosEnum parentesco;
    private Funcionario titular;

    public Dependente(
            String nome,
            String cpf,
            LocalDate dataNascimento,
            ParentescosEnum parentesco,
            Funcionario titular
    ) {
        super(nome, cpf, dataNascimento);

        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        if (idade >= 18) {
            throw new DependenteException("ERRO!!! Dependente não pode ser maior de 18 anos");
        }

        this.parentesco = parentesco;
        this.titular = titular;
    }

    public ParentescosEnum getParentesco() {
        return parentesco;
    }
}