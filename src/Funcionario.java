import java.time.LocalDate;

public class Funcionario extends Pessoa{

    private Double salarioBruto;
    private Double descontoInss;
    private Double descontoIr;

    public Funcionario(
            String nome,
            String cpf,
            LocalDate dataNascimento,
            Double salarioBruto,
            Double descontoInss,
            Double descontoIR
    ) {
        super(nome, cpf, dataNascimento);
        this.salarioBruto = salarioBruto;
        this.descontoInss = descontoInss;
        this.descontoIr = descontoIR;
    }

    public Double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(Double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public Double getDescontoInss() {
        return descontoInss;
    }

    public void setDescontoInss(Double descontoInss) {
        this.descontoInss = descontoInss;
    }

    public Double getDescontoIR() {
        return descontoIr;
    }

    public void setDescontoIR(Double descontoIR) {
        this.descontoIr = descontoIR;
    }
}
