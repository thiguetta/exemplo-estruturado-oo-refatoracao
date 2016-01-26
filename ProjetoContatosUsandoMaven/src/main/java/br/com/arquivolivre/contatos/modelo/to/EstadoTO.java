package br.com.arquivolivre.contatos.modelo.to;

import java.io.Serializable;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
public class EstadoTO implements Serializable {

    private int id;
    private String uf;
    private String descricao;

    public int getId() {
        return id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
