package Entity;

import Exception.DependenteException;
import java.time.LocalDate;
import java.util.UUID;

public class Dependente extends Pessoa {

    private UUID id;
    private String parentesco;
    private UUID idFuncionario;

    public Dependente(String nome, String cpf, LocalDate dataNascimento, String parentesco, UUID idFuncionario) {
        super(nome, cpf, dataNascimento);
        this.id = UUID.randomUUID();
        this.parentesco = parentesco;
        this.idFuncionario = idFuncionario;

        int idade = LocalDate.now().getYear() - dataNascimento.getYear();
        if (idade > 18) {
            throw new DependenteException("ERRO!!! Dependente não pode ser maior de 18 anos");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nDependente:");
        sb.append("\nNome: ").append(nome);
        sb.append("\nParentesco: ").append(parentesco);
        return sb.toString();
    }

    public UUID getId() { return id; }
    public String getParentesco() { return parentesco; }
    public UUID getIdFuncionario() { return idFuncionario; }
    public String getCpf() { return super.cpf; }
    public LocalDate getDataNascimento() { return super.dataNascimento; }
}