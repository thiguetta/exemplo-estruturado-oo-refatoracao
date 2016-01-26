package br.com.arquivolivre.contatos;

import br.com.arquivolivre.contatos.dao.impl.PessoaDAO;
import br.com.arquivolivre.contatos.modelo.Cidade;
import br.com.arquivolivre.contatos.modelo.Endereco;
import br.com.arquivolivre.contatos.modelo.Estado;
import br.com.arquivolivre.contatos.modelo.Logradouro;
import br.com.arquivolivre.contatos.modelo.to.PessoaTO;
import br.com.arquivolivre.contatos.servico.PessoaService;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws ParseException {
        PessoaDAO dao = new PessoaDAO();
        PessoaService service = new PessoaService(dao);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        PessoaTO pessoa = new PessoaTO();
        pessoa.setNome("Fulano de tal");
        pessoa.setCpf(12345678911l);
        pessoa.setDn(formatter.parse("10/10/1988"));

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

        pessoa.addEndereco(endereco);

        service.inserir(pessoa);

        System.out.println(service.listarTodos());

    }
}
