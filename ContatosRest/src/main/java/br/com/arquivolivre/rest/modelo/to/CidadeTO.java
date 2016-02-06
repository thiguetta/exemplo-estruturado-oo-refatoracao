package br.com.arquivolivre.rest.modelo.to;

import java.io.Serializable;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
public class CidadeTO implements Serializable {

    private int id;
    private String nome;
    private EstadoTO estado;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstadoTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoTO estado) {
        this.estado = estado;
    }

}
