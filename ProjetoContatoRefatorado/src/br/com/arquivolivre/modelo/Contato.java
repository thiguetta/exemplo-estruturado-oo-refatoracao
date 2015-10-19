package br.com.arquivolivre.modelo;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
public class Contato {

    private String nome;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return String.format("%s,%s", nome, telefone);
    }

    public void imprime() {
        System.out.printf("Nome: %s\n", nome);
        System.out.printf("Telefone: %s\n", telefone);
    }

}
