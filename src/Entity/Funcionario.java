package Entity;

import Exception.DependenteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Funcionario extends Pessoa {

    private UUID id;
    private Double salarioBruto;
    private Double salarioLiquido;
    private Double descontoInss;
    private Double descontoIr;
    private List<Dependente> dependentes;
    private Set<String> cpfsDependentes;

    public Funcionario(String nome, String cpf, LocalDate dataNascimento, Double salarioBruto) {
        super(nome, cpf, dataNascimento);
        this.id = UUID.randomUUID();
        this.salarioBruto = salarioBruto;
        this.dependentes = new ArrayList<>();
        this.cpfsDependentes = new HashSet<>();
    }

    public void addDependente(Dependente dependente) {
        if (cpfsDependentes.contains(dependente.getCpf())) {
            throw new DependenteException("ERRO!!! CPF de dependente já cadastrado");
        }
        this.dependentes.add(dependente);
        cpfsDependentes.add(dependente.getCpf());
    }

    public void calculoGeral() {
        CalculoPagamento calculoPagamento = new CalculoPagamento();
        this.descontoInss = calculoPagamento.calcularInss(salarioBruto);
        this.descontoIr = calculoPagamento.calcularIr(salarioBruto, dependentes.size());
        this.salarioLiquido = calculoPagamento.calcSalarioLiquido(salarioBruto, dependentes.size());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Funcionario:");
        sb.append("\nNome: ").append(nome);
        sb.append("\nCpf: ").append(cpf);
        sb.append("\nSalario: R$ ").append(String.format("%.2f", salarioBruto));
        sb.append("\nDesconto INSS: R$ ").append(String.format("%.2f", descontoInss));
        sb.append("\nDesconto IR: R$ ").append(String.format("%.2f", descontoIr));
        sb.append("\nSalario Liquido: R$ ").append(String.format("%.2f", salarioLiquido));
        for (Dependente d : dependentes) {
            sb.append(d);
        }
        return sb.toString();
    }

    public UUID getId() { return id; }
    public Double getSalarioBruto() { return salarioBruto; }
    public Double getSalarioLiquido() { return salarioLiquido; }
    public Double getDescontoInss() { return descontoInss; }
    public Double getDescontoIr() { return descontoIr; }
    public String getCpf() { return super.cpf; }
    public LocalDate getDataNascimento() { return super.dataNascimento; }
}