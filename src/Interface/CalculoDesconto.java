package Interface;

public interface CalculoDesconto {
     public Double calcularInss(Double salarioBruto);
     public Double calcularIr(Double salarioBruto, int quantDependente);
     public Double calcSalarioLiquido(double salarioBruto, int quantDependente);
}