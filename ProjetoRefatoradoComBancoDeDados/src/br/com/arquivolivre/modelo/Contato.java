package br.com.arquivolivre.modelo;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
public class Contato {

    private int id;
    private String nome;
    private String telefone;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s,%s", id, nome, telefone, email);
    }

    public void imprime() {
        System.out.printf("Id: %d\n", id);
        System.out.printf("Nome: %s\n", nome);
        System.out.printf("Telefone: %s\n", telefone);
        System.out.printf("Email: %s\n", email);
    }

}
