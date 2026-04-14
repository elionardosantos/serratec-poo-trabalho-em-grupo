import java.time.LocalDate;

public class Funcionario extends Pessoa{

    private Double salarioBruto;
    private Double salarioLiquido;
    private Double descontoInss;
    private Double descontoIr;

    public Funcionario(
            String nome,
            String cpf,
            LocalDate dataNascimento,
            Double salarioBruto
    ) {
        super(nome, cpf, dataNascimento);
        this.salarioBruto = salarioBruto;
    }

    public Funcionario(
            String nome,
            String cpf,
            LocalDate dataNascimento,
            Double salarioLiquido, Double descontoInss, Double descontoIr) {
        super(nome, cpf, dataNascimento);
        this.salarioLiquido = salarioLiquido;
        this.descontoInss = descontoInss;
        this.descontoIr = descontoIr;
    }
}
