<%@page import="java.util.List"%>
<%@page import="br.com.arquivolivre.contatos.modelo.Contato"%>
<%@page import="br.com.arquivolivre.contatos.db.ConectorMysql"%>
<%@page import="br.com.arquivolivre.contatos.db.ConectorBanco"%>
<%@page import="br.com.arquivolivre.contatos.dao.ContatoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ConectorBanco conector = new ConectorMysql("contatos", "root", "klapa22");
    ContatoDAO contatoDAO = new ContatoDAO(conector);
    List<Contato> contatos = contatoDAO.listarTodos();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contatos</title>
    </head>
    <body>
        <h1>Lista de contatos</h1>
        <table>
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Telefone</th>
                    <th>Email</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <tbody>
                <% for (Contato contato : contatos) {%>
                <tr>
                    <td><%=contato.getId()%></td>
                    <td><%=contato.getNome()%></td>
                    <td><%=contato.getTelefone()%></td>
                    <td><%=contato.getEmail()%></td>
                    <td>
                        <a href="contato.jsp?id=<%=contato.getId()%>">Editar</a>
                        <a href="remover.jsp?id=<%=contato.getId()%>">Apagar</a>
                    </td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </body>
</html>
