package br.com.arquivolivre.rest.servico;

import br.com.arquivolivre.rest.dao.impl.PessoaDAO;
import br.com.arquivolivre.rest.modelo.Pessoa;
import br.com.arquivolivre.rest.modelo.PessoaBuilder;
import br.com.arquivolivre.rest.modelo.to.PessoaTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zupsjrp
 */
@org.springframework.stereotype.Service
public class PessoaService implements IPessoaService {

    @Autowired
    private PessoaDAO dao;

    @Transactional
    @Override
    public void remover(Long id) {
        Pessoa pessoa = dao.buscaPorId(id);
        dao.remover(pessoa);
    }

    @Transactional
    @Override
    public void inserir(PessoaTO src) {
        dao.inserir(converter(src));
    }

    @Transactional
    @Override
    public void atualizar(PessoaTO src) {
        Pessoa pessoa = dao.buscaPorId(src.getCodigo());
        Pessoa atualizado = converter(src);
        pessoa.merge(atualizado);
        dao.atualizar(pessoa);
    }

    @Transactional
    @Override
    public void remover(PessoaTO src) {
        dao.remover(converter(src));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<PessoaTO> listarTodos() {
        return converterLista(dao.listarTodos());
    }

    @Transactional(propagation = Propagation.SUPPORTS)
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
        pessoaTO.setCodigo(pessoa.getId());
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
