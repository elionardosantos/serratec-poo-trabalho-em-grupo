package Exception;

public class DependenteException extends RuntimeException {
    public DependenteException(String mensagem) {
        super(mensagem);
    }
}

//  Tratar exceções de dependente:
//      - Todo dependente tem que ser menor que 18 anos.
//      - Não pode existir dependentes com o mesmo CPF.
//acho que foi