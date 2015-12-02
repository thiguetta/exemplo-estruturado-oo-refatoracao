<%@page import="br.com.arquivolivre.contatos.modelo.Contato"%>
<%@page import="br.com.arquivolivre.contatos.dao.ContatoDAO"%>
<%@page import="br.com.arquivolivre.contatos.db.ConectorMysql"%>
<%@page import="br.com.arquivolivre.contatos.db.ConectorBanco"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    String nome = request.getParameter("nome");
    String email = request.getParameter("email");
    String telefone = request.getParameter("telefone");
    ConectorBanco conector = new ConectorMysql("contatos", "root", "klapa22");
    ContatoDAO contatoDAO = new ContatoDAO(conector);
    Contato contato = new Contato();
    contato.setNome(nome);
    contato.setTelefone(telefone);
    contato.setEmail(email);
    if (id == null) {
        contatoDAO.inserir(contato);
    } else {
        contato.setId(Integer.parseInt(id));
        contatoDAO.atualizar(contato);
    }
    response.sendRedirect("lista_contatos.jsp");
%>
