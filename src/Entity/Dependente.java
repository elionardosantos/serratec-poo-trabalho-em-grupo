package Entity;

import java.time.LocalDate;

public class Dependente extends Pessoa{

    private String parentesco;
    private Pessoa titular;

    public Dependente(String nome, String cpf, LocalDate dataNascimento, String parentesco, Pessoa titular) {
        super(nome, cpf, dataNascimento);
        this.parentesco = parentesco;
        this.titular = titular;
    }
}
