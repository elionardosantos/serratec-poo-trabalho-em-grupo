package Entity;

import java.time.LocalDate;
import Exception.DependenteException;
import java.time.Period;
import Entity.Pessoa;
import Enum.ParentescosEnum;
import Entity.EntradaDados;

public class Dependente extends Pessoa{

    private ParentescosEnum parentesco;


    public Dependente(String nome, String cpf, LocalDate dataNascimento, ParentescosEnum parentesco) throws DependenteException {
        super(nome, cpf, dataNascimento);
        this.parentesco = parentesco;
        LocalDate hoje = LocalDate.now();
        int idade = Period.between(getDataNascimento(), hoje).getYears();

        if (idade >= 18) {
            throw new DependenteException("Dependente deve ter menos de 18 anos!");
        }
    }
}