package br.com.arquivolivre.rest.controlador;

import br.com.arquivolivre.rest.modelo.to.PessoaTO;
import br.com.arquivolivre.rest.servico.IPessoaService;
import br.com.arquivolivre.rest.servico.PessoaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
@RestController
@RequestMapping("/contato")
public class ControladorPessoa {

    @Autowired
    private IPessoaService service;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<PessoaTO> listarTodos() {
        return service.listarTodos();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void salvarPessoa(@RequestBody PessoaTO pessoa) {
        service.inserir(pessoa);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public PessoaTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public void atualizarPessoa(@RequestBody PessoaTO pessoa) {
        service.atualizar(pessoa);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}
