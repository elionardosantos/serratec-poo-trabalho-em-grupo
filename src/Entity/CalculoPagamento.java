package Entity;

import Interface.CalculoDesconto;

public class CalculoPagamento implements CalculoDesconto {

    @Override
    public Double calcularInss(Double salarioBruto) {
        double aliquota;
        double parcDeduzir;

        if (salarioBruto > 8157.41) {
            return 8157.41 * 0.14;
        } else if (salarioBruto <= 1518.0) {
            aliquota = 0.075; parcDeduzir = 0;
        } else if (salarioBruto <= 2793.88) {
            aliquota = 0.09; parcDeduzir = 22.77;
        } else if (salarioBruto <= 4190.83) {
            aliquota = 0.12; parcDeduzir = 106.60;
        } else {
            aliquota = 0.14; parcDeduzir = 190.42;
        }

        return (salarioBruto * aliquota) - parcDeduzir;
    }

    @Override
    public Double calcularIr(Double salarioBruto, int quantDependente) {
        double aliquota;
        double parcDeduzir;

        if (salarioBruto <= 2259.0) {
            aliquota = 0.0; parcDeduzir = 0;
        } else if (salarioBruto <= 2826.65) {
            aliquota = 0.075; parcDeduzir = 169.44;
        } else if (salarioBruto <= 3751.05) {
            aliquota = 0.15; parcDeduzir = 381.44;
        } else if (salarioBruto <= 4664.68) {
            aliquota = 0.225; parcDeduzir = 662.77;
        } else {
            aliquota = 0.275; parcDeduzir = 896.0;
        }

        double descontoIr = ((salarioBruto - (quantDependente * 189.59) - calcularInss(salarioBruto)) * aliquota) - parcDeduzir;
        return descontoIr <= 0 ? 0.0 : descontoIr;
    }

    @Override
    public Double calcSalarioLiquido(double salarioBruto, int quantDependente) {
        return salarioBruto - calcularInss(salarioBruto) - calcularIr(salarioBruto, quantDependente);
    }
}