package br.com.arquivolivre.contatos.servico;

import br.com.arquivolivre.contatos.dao.impl.PessoaDAO;
import br.com.arquivolivre.contatos.modelo.Pessoa;
import br.com.arquivolivre.contatos.modelo.PessoaBuilder;
import br.com.arquivolivre.contatos.modelo.to.PessoaTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zupsjrp
 */
public class PessoaService implements CrudService<PessoaDAO, PessoaTO> {

    private final PessoaDAO dao;

    public PessoaService(PessoaDAO dao) {
        this.dao = dao;
    }

    public void remover(Long id) {
        Pessoa pessoa = dao.buscaPorId(id);
        dao.remover(pessoa);
    }

    @Override
    public void inserir(PessoaTO src) {
        dao.inserir(converter(src));
    }

    @Override
    public void atualizar(PessoaTO src) {
        dao.atualizar(converter(src));
    }

    @Override
    public void remover(PessoaTO src) {
        dao.remover(converter(src));
    }

    @Override
    public List<PessoaTO> listarTodos() {
        return converterLista(dao.listarTodos());
    }

    @Override
    public PessoaTO buscarPorId(Long id) {
        return converter(dao.buscaPorId(id));
    }

    private Pessoa converter(PessoaTO pessoaTO) {
        PessoaBuilder builder = new PessoaBuilder();
        builder.comNome(pessoaTO.getNome())
                .comEmail(pessoaTO.getEmail())
                .comTelefone(pessoaTO.getTel())
                .nascidoEm(pessoaTO.getDn())
                .portadorDoCpf(pessoaTO.getCpf())
                .ativo(pessoaTO.getA());
        return builder.criarPessoa();
    }

    private PessoaTO converter(Pessoa pessoa) {
        PessoaTO pessoaTO = new PessoaTO();
        pessoaTO.setNome(pessoa.getNome());
        pessoaTO.setTel(pessoa.getTelefone());
        pessoaTO.setCpf(pessoa.getCpf());
        pessoaTO.setEmail(pessoa.getEmail());
        pessoaTO.setDn(pessoa.getDataNascimento());
        pessoaTO.setA(pessoa.getAtivo());
        return pessoaTO;
    }

    private List<PessoaTO> converterLista(List<Pessoa> pessoas) {
        List<PessoaTO> pessoaTos = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            pessoaTos.add(converter(pessoa));
        }
        return pessoaTos;
    }

}
