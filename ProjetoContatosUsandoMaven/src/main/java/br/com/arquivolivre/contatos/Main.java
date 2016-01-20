package br.com.arquivolivre.contatos;

import br.com.arquivolivre.contatos.dao.impl.PessoaDAO;
import br.com.arquivolivre.contatos.modelo.Cidade;
import br.com.arquivolivre.contatos.modelo.Endereco;
import br.com.arquivolivre.contatos.modelo.Estado;
import br.com.arquivolivre.contatos.modelo.Logradouro;
import br.com.arquivolivre.contatos.modelo.Pessoa;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws ParseException {
        PessoaDAO dao = new PessoaDAO();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Fulano de tal");
        pessoa.setCpf(12345678911l);
        pessoa.setDataNascimento(formatter.parse("10/10/1988"));
        
        Endereco endereco = new Endereco();
        endereco.setNumero("11");
        
        Logradouro logradouro = new Logradouro();
        
        logradouro.setLogradouro("Rua Fulano de tal");
        logradouro.setBairro("Bairro");
        logradouro.setCep(15010000l);
        
        Cidade cidade = new Cidade();
        cidade.setNome("São José do Rio Preto");
        
        Estado estado = new Estado();
        estado.setUf("SP");
        estado.setDescricao("São Paulo");
        
        cidade.setEstado(estado);
        
        logradouro.setCidade(cidade);
        
        endereco.setLogradouro(logradouro);
        
        pessoa.setEnderecos(Arrays.asList(endereco));
        
        dao.inserir(pessoa);
        
        System.out.println(dao.listarTodos());
        
        
    }
}
