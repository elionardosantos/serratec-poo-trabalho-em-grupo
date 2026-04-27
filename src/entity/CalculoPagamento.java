package entity;

import interfaces.CalculoDesconto;

public class CalculoPagamento implements CalculoDesconto {

    public CalculoPagamento() {
    }

    @Override
    public Double calcularInss(Double salarioBruto) {

        double descontoInss;
        double aliquota = 0.0;
        double parcDeduzir = 0.0;
        double valorDesconto;

        if (salarioBruto > 8157.41){

            descontoInss = 8157.41 * 0.14;
            valorDesconto = descontoInss;

        } else {
            if (salarioBruto <= 1518.0) {
                aliquota = 0.075;
                parcDeduzir = 0;

            } else if (salarioBruto <= 2793.88) {
                aliquota = 0.09;
                parcDeduzir = 22.77;

            } else if (salarioBruto <= 4190.83) {
                aliquota = 0.12;
                parcDeduzir = 106.60;

            } else if (salarioBruto <= 8157.41) {
                aliquota = 0.14;
                parcDeduzir = 190.42;
            }

            descontoInss = (salarioBruto * aliquota) - parcDeduzir;
            valorDesconto = descontoInss;
        }

        return valorDesconto;
    }

    @Override
    public Double calcularIr(Double salarioBruto, int quantDependente) {

        double salario = salarioBruto - (quantDependente * 189.59) - calcularInss(salarioBruto);

        double descontoIr;
        double aliquota;
        double parcDeduzir;

        if (salario <= 2259.0) {
            aliquota = 0.0;
            parcDeduzir = 0;

        } else if (salario <= 2826.65) {
            aliquota = 0.075;
            parcDeduzir = 169.44;

        } else if (salario <= 3751.05) {
            aliquota = 0.15;
            parcDeduzir = 381.44;

        } else if (salario <= 4664.68) {
            aliquota = 0.225;
            parcDeduzir = 662.77;

        } else {
            aliquota = 0.275;
            parcDeduzir = 896.0;
        }

        descontoIr = (salario * aliquota) - parcDeduzir;

        if (descontoIr <= 0) {
            return 0.0;
        } else {
            return descontoIr;
        }
    }

    @Override
    public Double calcSalarioLiquido(double salarioBruto, int quantDependente) {

        double salarioLiquido;

        salarioLiquido = salarioBruto - calcularInss(salarioBruto) - calcularIr(salarioBruto, quantDependente);

        return salarioLiquido;
    }
}
