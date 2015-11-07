package br.com.arquivolivre;

import br.com.arquivolivre.modelo.Contato;
import java.util.Scanner;

public class LeitorContato {

    private final Scanner teclado = new Scanner(System.in);

    public Contato lerContatoDoTeclado() {
        Contato novoContato = new Contato();
        System.out.print("Nome: ");
        novoContato.setNome(teclado.nextLine());
        System.out.print("Telefone: ");
        novoContato.setTelefone(teclado.nextLine());
        return novoContato;
    }
}
