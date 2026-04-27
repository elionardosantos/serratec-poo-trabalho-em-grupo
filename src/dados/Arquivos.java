package dados;

import java.io.File;
import java.util.Scanner;

public class Arquivos {

    public static String listar(String caminho) {
        File pasta = new File(caminho);
        File[] arquivos = pasta.listFiles();

        if (arquivos == null || arquivos.length == 0) {
            System.out.println("A pasta CSV está vazia.");
            return null;
        }

        System.out.println("Digite o número do arquivo abaixo: ");
        for (int i = 0; i < arquivos.length; i++) {
            System.out.println((i + 1) + ". " + arquivos[i].getName());
        }
        System.out.print("-> ");
        Scanner scanner = new Scanner(System.in);

        try {
            int escolha = scanner.nextInt();
            if (escolha > 0 && escolha <= arquivos.length) {
                return arquivos[escolha - 1].getAbsolutePath();
            } else {
                System.out.println("Opção inválida.");
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida. Digite apenas números.");
        }

        return null;
    }
}