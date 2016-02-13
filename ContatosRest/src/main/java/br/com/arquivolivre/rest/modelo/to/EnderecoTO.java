package br.com.arquivolivre.rest.modelo.to;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
@XmlRootElement
public class EnderecoTO implements Serializable {

    private int id;
    private String apelido;
    private String numero;
    private String complemento;
    private PessoaTO pessoa;
    private LogradouroTO logradouro;

    public int getId() {
        return id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LogradouroTO getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(LogradouroTO logradouro) {
        this.logradouro = logradouro;
    }

    public PessoaTO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaTO pessoa) {
        this.pessoa = pessoa;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

}
