<%@page import="clases.Categorias" %>
<%
    Categorias item = (Categorias) request.getAttribute("item");
    String tipo = (String) request.getAttribute("tipo");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#9B59B6" >
        <h1><%= (tipo == "new") ? "Nueva" : "Editar"%>Categoria</h1>
        <form action="CategoriaController" method="post">
            <input type="hidden" name="tipo" value="<%= tipo %>"/>
            <table>
                    <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" value="<%= item.getId()%>"/></td>
                    </tr>
                    <tr>
                    <td>Categoria</td>
                    <td><input type="text" name="categoria" value="<%= item.getCategoria()%>"/></td>
                    </tr>
                    <tr>
                    <td></td>
                    <td><input type="submit">Enviar</td>
                </tr>
            </table>
        </form>
    </body>
</html>
