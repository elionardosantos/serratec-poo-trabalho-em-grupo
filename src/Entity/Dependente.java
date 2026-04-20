package Entity;

import java.time.LocalDate;
import java.util.UUID;

public class Dependente extends Pessoa{

    private String parentesco;
    private UUID idFuncionario;

    public Dependente(String nome, String cpf, LocalDate dataNascimento, String parentesco, UUID idFuncionario) {
        super(nome, cpf, dataNascimento);
        this.parentesco = parentesco;
        this.idFuncionario = idFuncionario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nDependente:");
        sb.append("\nNome: ").append(nome);
        sb.append("\nParentesco: ").append(parentesco);
        sb.append("\nFuncionario: ").append(idFuncionario);
        return sb.toString();
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public UUID getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(UUID idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
