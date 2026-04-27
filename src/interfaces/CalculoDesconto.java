package interfaces;

public interface CalculoDesconto {

     Double calcularInss(Double salarioBruto);
     Double calcularIr(Double salarioBruto, int quantDependente);
     Double calcSalarioLiquido(double salarioBruto, int quantDependente);
}