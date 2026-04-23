package Entity;

import java.time.LocalDate;

public class FolhaPagamento {
    private int codigo;
    private Funcionario funcionario;
    private LocalDate dataPagamento;
    private double descontoINSS;
    private double descontoIR;
    private double salarioLiquido;

    public FolhaPagamento(int codigo, Funcionario funcionario, LocalDate dataPagamento,
                          double descontoINSS, double descontoIR, double salarioLiquido) {
        this.codigo = codigo;
        this.funcionario = funcionario;
        this.dataPagamento = dataPagamento;
        this.descontoINSS = descontoINSS;
        this.descontoIR = descontoIR;
        this.salarioLiquido = salarioLiquido;
    }

    public int getCodigo() { return codigo; }
    public Funcionario getFuncionario() { return funcionario; }
    public LocalDate getDataPagamento() { return dataPagamento; }
    public double getDescontoINSS() { return descontoINSS; }
    public double getDescontoIR() { return descontoIR; }
    public double getSalarioLiquido() { return salarioLiquido; }

    @Override
    public String toString() {
        return funcionario.getNome() + ";" +
                funcionario.getCpf() + ";" +
                String.format("%.2f", descontoINSS) + ";" +
                String.format("%.2f", descontoIR) + ";" +
                String.format("%.2f", salarioLiquido);
    }
}