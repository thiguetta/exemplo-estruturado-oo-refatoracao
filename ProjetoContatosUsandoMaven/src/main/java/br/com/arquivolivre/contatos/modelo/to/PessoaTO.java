package br.com.arquivolivre.contatos.modelo.to;

import java.util.Date;

/**
 *
 * @author zupsjrp
 */
public class PessoaTO {

    private Long codigo;
    private String nome;
    private String tel;
    private String email;
    private Long cpf;
    private Date dn;
    private Boolean a = true;

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public Date getDn() {
        return dn;
    }

    public void setDn(Date dn) {
        this.dn = dn;
    }

    public Boolean getA() {
        return a;
    }

    public void setA(Boolean a) {
        this.a = a;
    }
    
    
}
