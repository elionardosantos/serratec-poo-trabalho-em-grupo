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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nDependente:");
        sb.append("\nNome: ").append(nome);
        sb.append("\nParentesco: ").append(parentesco);
        sb.append("\nFuncionario: ").append(titular.getNome());
        return sb.toString();
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }
}
