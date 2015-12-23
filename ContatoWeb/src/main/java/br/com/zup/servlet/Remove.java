package br.com.zup.servlet;

import br.com.arquivolivre.contatos.modelo.Contato;
import br.com.zup.controller.ContatosController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/remove")
public class Remove extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ContatosController controller = new ContatosController();
        Contato contato = new Contato();
        contato.setId(Integer.parseInt(id));
        controller.remover(contato);
        response.sendRedirect("lista_contatos.jsp");
    }

}
