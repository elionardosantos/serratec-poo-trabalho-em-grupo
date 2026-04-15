package Exception;

public class DependenteException extends Exception {

        public DependenteException(String mensagem) {
            super(mensagem);
        }
    }


//  Tratar exceções de dependente:
//      - Todo dependente tem que ser menor que 18 anos.
//      - Não pode existir dependentes com o mesmo CPF.