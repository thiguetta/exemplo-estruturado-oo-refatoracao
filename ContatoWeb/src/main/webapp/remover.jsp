<%@page import="br.com.arquivolivre.contatos.modelo.Contato"%>
<%@page import="br.com.arquivolivre.contatos.dao.ContatoDAO"%>
<%@page import="br.com.arquivolivre.contatos.db.ConectorMysql"%>
<%@page import="br.com.arquivolivre.contatos.db.ConectorBanco"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    ConectorBanco conector = new ConectorMysql("contatos", "root", "klapa22");
    ContatoDAO contatoDAO = new ContatoDAO(conector);
    Contato contato = new Contato();
    contato.setId(Integer.parseInt(id));
    contatoDAO.remover(contato);
    response.sendRedirect("lista_contatos.jsp");
%>
