package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Funcionario extends Pessoa{

    private UUID id;
    private Double salarioBruto;
    private Double salarioLiquido;
    private Double descontoInss;
    private Double descontoIr;
    private List<Dependente> dependentes;

    public Funcionario(String nome, String cpf, LocalDate dataNascimento, Double salarioBruto) {
        super(nome, cpf, dataNascimento);
        this.id = UUID.randomUUID();
        this.salarioBruto = salarioBruto;
        this.dependentes = new ArrayList<>();
    }

    public Funcionario(String nome, String cpf, LocalDate dataNascimento, Double salarioLiquido, Double descontoInss, Double descontoIr) {
        super(nome, cpf, dataNascimento);
        this.salarioLiquido = salarioLiquido;
        this.descontoInss = descontoInss;
        this.descontoIr = descontoIr;
    }

    public void addDependente(Dependente dependente){
        this.dependentes.add(dependente);
    }

    public void calculoGeral(){
        CalculoPagamento calculoPagamento = new CalculoPagamento();
        this.descontoInss =  calculoPagamento.calcularInss(salarioBruto);
        this.descontoIr = calculoPagamento.calcularIr(salarioBruto, dependentes.size());
        this.salarioLiquido = calculoPagamento.calcSalarioLiquido(salarioBruto, dependentes.size());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Funcionario:");
        sb.append("\nNome: ").append(nome);
        sb.append("\nCpf: ").append(cpf);
        sb.append("\nDataNascimento: ").append(dataNascimento);
        sb.append("\nSalario: R$ ").append(String.format("%.2f",(salarioBruto)));
        sb.append("\nDesconto do INSS: R$ ").append(String.format("%.2f",(descontoInss)));
        sb.append("\nDesconto do IR: R$ ").append(String.format("%.2f",(descontoIr)));
        sb.append("\nSalario Liquido: R$ ").append(String.format("%.2f",(salarioLiquido)));
        for (Dependente d : dependentes) {
            sb.append(d);
        }
        return sb.toString();
    }

    public Double getSalarioBruto() {
        return salarioBruto;
    }

    public Double getSalarioLiquido() {
        return salarioLiquido;
    }

    public Double getDescontoInss() {
        return descontoInss;
    }

    public Double getDescontoIr() {
        return descontoIr;
    }

    public UUID getId() {
        return id;
    }
}
