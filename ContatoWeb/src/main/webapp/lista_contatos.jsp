<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="contatoController" class="br.com.zup.controller.ContatosController" scope="page"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Contatos</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Telefone</th>
                    <th>Email</th>
                    <th>AÃ§Ã£o</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="contato" items="${contatoController.listarTodos()}">
                    <tr>
                        <td>${contato.getCodigo()}</td>
                        <td>${contato.getNome()}</td>
                        <td>${contato.getTel()}</td>
                        <td>${contato.getEmail()}</td>
                        <td>
                            <a href="contato?id=${contato.getCodigo()}">Editar</a>
                            <a href="remove?id=${contato.getCodigo()}">Apagar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
