package com.arquivolivre.contato.modelo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, nullable = false)
    private String nome;

    @Column(length = 11)
    private String telefone;

    private String email;

    @Column(length = 11, nullable = false, unique = true)
    private Long cpf;

    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    private Date dataNascimento;

    private Boolean ativo = true;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    protected Pessoa() {

    }

    Pessoa(String nome, String telefone, String email, Long cpf, Date dataNascimento, Boolean ativo, List<Endereco> enderecos) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.ativo = ativo;
        this.enderecos = enderecos;
    }

    public Long getId() {
        return id;
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

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.cpf, other.cpf);
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", ativo=" + ativo + ", enderecos=" + enderecos + '}';
    }

    public void merge(Pessoa p) {
//        this.ativo = p.ativo;
//        this.cpf = p.cpf;
//        this.dataNascimento = p.dataNascimento;
//        this.email = p.email;
//        this.telefone = p.telefone;
//        this.enderecos = p.enderecos
//        this.nome = p.nome;

        Field[] campos = this.getClass().getDeclaredFields();
        for (Field campo : campos) {
            try {
                Object esta = campo.get(this);
                Object outra = campo.get(p);
                if (!esta.equals(outra) && !"id".equals(campo.getName())) {
                    campo.set(this, outra);
                }
            } catch (IllegalAccessException | IllegalArgumentException ex) {

            }
        }

    }

}
