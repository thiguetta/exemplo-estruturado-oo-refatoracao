<%@page import="br.com.zup.controller.ContatosController"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="registro"> 
            <c:if test="${not empty contato.getCodigo()}">
                <input type="hidden" value="${contato.getCodigo()}">
            </c:if>
            <input type="text" placeholder="Nome" name="nome" value="${contato.getNome()}">
            <input type="text" placeholder="Telefone" name="telefone" value="${contato.getTel()}">
            <input type="text" placeholder="Email" name="email" value="${contato.getEmail()}">
            <button type="submit">Enviar</button>
        </form>
    </body>
</html>
