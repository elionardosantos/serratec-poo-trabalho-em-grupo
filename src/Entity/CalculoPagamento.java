package Entity;

import Interface.CalculoDesconto;

public class CalculoPagamento implements CalculoDesconto {

    @Override
    public Double calcularInss(Double salarioBruto) {
        // Retorna somente o valor do desconto

        double descontoInss;
        double aliquota = 0.0;
        double parcDeduzir = 0.0;
        double valorDesconto;

        if (salarioBruto > 8157.41){

            // Acima de R$ 8.157,41 o valor é fixo.

            aliquota = 0.14;

            descontoInss = 8157.41 * aliquota;
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
                parcDeduzir = 1016.6;


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
        // Retorna somente o valor do desconto

        double descontoIr;
        double aliquota;
        double parcDeduzir;

        if (salarioBruto <= 2259.0) {
            aliquota = 0.0;
            parcDeduzir = 0;

        } else if (salarioBruto <= 2826.65) {
            aliquota = 0.075;
            parcDeduzir = 169.44;

        } else if (salarioBruto <= 3751.05) {
            aliquota = 0.15;
            parcDeduzir = 381.44;

        } else if (salarioBruto <= 4664.68) {
            aliquota = 0.225;
            parcDeduzir = 662.77;

        } else {
            aliquota = 0.275;
            parcDeduzir = 896.0;
        }

        descontoIr = ((salarioBruto - (quantDependente * 189.59) - this.calcularInss(salarioBruto)) * aliquota) - parcDeduzir;

        if (descontoIr <= 0) {
            return 0.0;

        } else {
            return descontoIr;

        }

    }

    @Override
    public Double calcSalarioLiquido(double salarioBruto, int quantDependente) {
        // Retorna salário bruto - INSS - IR

        double salarioLiquido;

        salarioLiquido = salarioBruto - calcularInss(salarioBruto) - calcularIr(salarioBruto, quantDependente);

        return salarioLiquido;
    }

}
