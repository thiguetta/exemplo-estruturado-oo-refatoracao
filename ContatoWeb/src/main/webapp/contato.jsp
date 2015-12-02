<%@page import="br.com.arquivolivre.contatos.modelo.Contato"%>
<%@page import="br.com.arquivolivre.contatos.db.ConectorMysql"%>
<%@page import="br.com.arquivolivre.contatos.db.ConectorBanco"%>
<%@page import="br.com.arquivolivre.contatos.dao.ContatoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    Contato contato = Contato.novoContatoVazio();
    if (id != null) {
        ConectorBanco conector = new ConectorMysql("contatos", "root", "klapa22");
        ContatoDAO contatoDAO = new ContatoDAO(conector);
        contato = contatoDAO.buscarPorId(Integer.parseInt(id));
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="registro.jsp">
            <%if (id != null) {%>
            <input type="hidden" name="id" value="<%=contato.getId()%>">
            <%}%>
            <input type="text" placeholder="nome" name="nome" value="<%=contato.getNome()%>">
            <input type="text" placeholder="telefone" name="telefone" value="<%=contato.getTelefone()%>">
            <input type="text" placeholder="email" name="email" value="<%=contato.getEmail()%>">
            <button type="submit">Enviar</button>
        </form>
    </body>
</html>
