package br.com.arquivolivre.contatos.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
@Entity
public class Cidade implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(length = 60, nullable = false)
    private String nome;
    @ManyToOne(cascade = CascadeType.ALL)
    @Basic(optional = false)
    private Estado estado;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
