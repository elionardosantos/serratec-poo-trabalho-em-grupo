package Entity;

import Interface.CalculoDesconto;

public class CalculoPagamento implements CalculoDesconto {

    @Override
    public Double calcularINSS(Double salarioBruto) {
        return 0.0;
    }

    @Override
    public Double calcularIR(Double salarioBruto) {
        return 0.0;
    }

    @Override
    public Double calcularSalario() {
        return 0.0;
    }
}
