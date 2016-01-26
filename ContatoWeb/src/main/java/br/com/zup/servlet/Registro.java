package br.com.zup.servlet;

import br.com.arquivolivre.contatos.modelo.to.PessoaTO;
import br.com.zup.controller.ContatosController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registro")
public class Registro extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        Long idLong = id == null ? null : Long.parseLong(id);

        ContatosController controller = new ContatosController();

        PessoaTO contato = new PessoaTO();
        contato.setCodigo(idLong);
        contato.setNome(nome);
        contato.setTel(telefone);
        contato.setEmail(email);
        controller.salvar(contato);

        response.sendRedirect("lista_contatos.jsp");
    }

}
