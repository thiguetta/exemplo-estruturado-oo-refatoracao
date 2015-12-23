package br.com.zup.servlet;

import br.com.arquivolivre.contatos.modelo.Pessoa;
import br.com.zup.controller.ContatosController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contato")
public class ContatoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ContatosController controller = new ContatosController();
        Pessoa contato = controller.getContato(id);
        request.setAttribute("contato", contato);
        request.getRequestDispatcher("contato.jsp").forward(request, response);
    }

}
