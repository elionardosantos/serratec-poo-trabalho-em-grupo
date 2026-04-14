package Enum;

public enum FaixasSalarioEnum {

//    FAIXA(REMUNERACAO, ALIQUOTA_POR_FAIXA, )
    FAIXA1(1518.00, 7.5),
    FAIXA2(2793.88, 9),
    FAIXA3(4190.83, 12),
    FAIXA4(8157.41, 14);

    private Double salario;
    private Double aliquita;

    FaixasSalarioEnum(Double salario, double aliquita) {
        this.salario = salario;
        this.aliquita = aliquita;
    }

    public Double getSalario() {
        return salario;
    }
}
