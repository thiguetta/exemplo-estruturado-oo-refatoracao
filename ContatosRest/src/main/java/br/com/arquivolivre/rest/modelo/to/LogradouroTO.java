package br.com.arquivolivre.rest.modelo.to;

import java.io.Serializable;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
public class LogradouroTO implements Serializable {

    private int id;
    private String logradouro;
    private String bairro;
    private Long cep;
    private CidadeTO cidade;

    public int getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public CidadeTO getCidade() {
        return cidade;
    }

    public void setCidade(CidadeTO cidade) {
        this.cidade = cidade;
    }

}
