package br.com.arquivolivre.rest.controlador;

import br.com.arquivolivre.rest.modelo.to.PessoaTO;
import br.com.arquivolivre.rest.servico.PessoaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    private PessoaService service;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<PessoaTO> listarTodos() {
        return service.listarTodos();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void salvarPessoa(@RequestBody PessoaTO pessoa) {
        service.inserir(pessoa);
    }

}
