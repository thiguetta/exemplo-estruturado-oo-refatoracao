package com.arquivolivre.contato.controlador;

import com.arquivolivre.contato.modelo.Usuario;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thiago
 */
@RestController
@RequestMapping("/controlador")
public class ControladorRest {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario ok() {
        Usuario u = new Usuario();
        u.setMensagem("está é uma mensagem");
        u.setUsuario("meu usuario");
        return u;
    }
}
