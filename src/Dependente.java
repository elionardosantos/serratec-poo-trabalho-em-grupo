import java.time.LocalDate;

public class Dependente extends Pessoa{

    private String parentesco;

    public Dependente(String nome, String cpf, LocalDate dataNascimento, String parentesco) {
        super(nome, cpf, dataNascimento);

        switch (parentesco){
            case "Filho", "Sobrinho", "Outros":
                this.parentesco = parentesco;
            default:
//              Não definido
        }

        this.parentesco = parentesco;
    }
}
