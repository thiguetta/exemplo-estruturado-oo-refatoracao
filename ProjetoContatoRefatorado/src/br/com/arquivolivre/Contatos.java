package br.com.arquivolivre;

import br.com.arquivolivre.modelo.Contato;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Contatos implements Iterable<Contato> {

    private final List<Contato> contatos;

    public Contatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public Contato buscaContato(String nomeDoContato) {
        for (Contato contato : contatos) {
            if (contato.getNome().equals(nomeDoContato)) {
                return contato;
            }
        }
        return null;
    }

    @Override
    public Iterator<Contato> iterator() {
        return contatos.iterator();
    }

}
