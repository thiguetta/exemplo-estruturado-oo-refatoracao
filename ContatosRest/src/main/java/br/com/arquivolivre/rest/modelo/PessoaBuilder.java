package br.com.arquivolivre.rest.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PessoaBuilder {

    private String nome;
    private String telefone;
    private String email;
    private Long cpf;
    private Date dataNascimento;
    private List<Endereco> enderecos;
    private Boolean ativo;

    public PessoaBuilder() {
    }

    public PessoaBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaBuilder comTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public PessoaBuilder comEmail(String email) {
        this.email = email;
        return this;
    }

    public PessoaBuilder portadorDoCpf(Long cpf) {
        this.cpf = cpf;
        return this;
    }

    public PessoaBuilder nascidoEm(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public PessoaBuilder noEndereco(Endereco endereco){
        if(enderecos==null){
            enderecos = new ArrayList<>();
        }
        enderecos.add(endereco);
        return this;
    }
    
    public PessoaBuilder ativo(Boolean ativo) {
        this.ativo = ativo; 
        return this;
    }

    public Pessoa criarPessoa() {
        return new Pessoa(nome, telefone, email, cpf, dataNascimento, ativo, enderecos);
    }

}
