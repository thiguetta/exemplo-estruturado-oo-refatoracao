package br.com.arquivolivre;

import br.com.arquivolivre.modelo.Contato;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArquivoContato {

    private final File arquivo;

    public ArquivoContato(String nomeDoArquivo) {
        this.arquivo = new File(nomeDoArquivo);
    }

    public List<Contato> lerContatosDoArquivo() {
        List<Contato> contatos = new ArrayList<>();
        try (Scanner scanner = new Scanner(arquivo)) {
            scanner.useDelimiter(",|\n");
            while(scanner.hasNext()) {
                Contato contato = new Contato();
                contato.setNome(scanner.next());
                contato.setTelefone(scanner.next());
                contatos.add(contato);
            }
        } catch (FileNotFoundException ex) {
        }
        return contatos;
    }

    public void salvarContatosNoArquivo(Contatos contatos) {
        try (PrintWriter writer = new PrintWriter(arquivo)) {
            for (Contato pessoa : contatos) {
                writer.println(pessoa.toString());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
