package Entity;

import java.time.LocalDate;
import java.util.UUID;

public class FolhaPagamento {

    private UUID id;
    private int codigo;
    private Funcionario funcionario;
    private LocalDate dataPagamento;
    private double descontoINSS;
    private double descontoIR;
    private double salarioLiquido;

    public FolhaPagamento(int codigo, Funcionario funcionario, LocalDate dataPagamento, double descontoINSS, double descontoIR, double salarioLiquido) {
        this.id = UUID.randomUUID();
        this.codigo = codigo;
        this.funcionario = funcionario;
        this.dataPagamento = dataPagamento;
        this.descontoINSS = descontoINSS;
        this.descontoIR = descontoIR;
        this.salarioLiquido = salarioLiquido;
    }

    public FolhaPagamento(UUID id, int codigo, Funcionario funcionario, LocalDate dataPagamento, double descontoINSS, double descontoIR, double salarioLiquido) {
        this.id = id;
        this.codigo = codigo;
        this.funcionario = funcionario;
        this.dataPagamento = dataPagamento;
        this.descontoINSS = descontoINSS;
        this.descontoIR = descontoIR;
        this.salarioLiquido = salarioLiquido;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nFolha de Pagamento:");
        sb.append("\nCódigo: ").append(codigo);
        sb.append("\nData: ").append(dataPagamento);
        sb.append("\nFuncionário: ").append(funcionario.getNome());
        sb.append("\nSalário Bruto: R$ ").append(String.format("%.2f", funcionario.getSalarioBruto()));
        sb.append("\nDesconto INSS: R$ ").append(String.format("%.2f", descontoINSS));
        sb.append("\nDesconto IR: R$ ").append(String.format("%.2f", descontoIR));
        sb.append("\nSalário Líquido: R$ ").append(String.format("%.2f", salarioLiquido));
        return sb.toString();
    }

    public int getCodigo() {
        return codigo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public double getDescontoINSS() {
        return descontoINSS;
    }

    public double getDescontoIR() {
        return descontoIR;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public UUID getId() {
        return id;
    }
}

