<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="clases.Categorias"%>
<%@page import="clases.Libros"%>
<%
    Libros lib = (Libros) request.getAttribute("lib");
    List<Categorias> categoria = (List<Categorias>) request.getAttribute("categoria");
    String tipo = (String) request.getAttribute("tipo");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#9B59B6">
        <h1><%= (tipo == "new") ? "Nuevo" : "Editar" %>Libros</h1>
        <form action="libroController" method="post">
            <input type="hidden" name="tipo" value="<%= tipo%>">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name ="id" value ="<%= lib.getId()%>" readonly></td>
                </tr>
                <tr>
                    <td>Titulo</td>
                    <td><input type="text" name ="titulo" value="<%=lib.getTitulo()%>"></td>
                </tr>
                <tr>
                    <td>Autor</td>
                    <td><input type="text" name ="autor" value="<%= lib.getAutor()%>"></td>
                </tr>
                <tr>
                    <td>Disponible</td>
                    <td><input type="text" name ="disponible" value="<%= lib.getDisponible()%>"></td>
                </tr>
                <tr>
                    <td>Categoria</td>
                    <td><select name ="idcat">
                            <%
                                for (Categorias c : categoria){
                            %>
                            <option value ="<%= c.getId()%>" ${c.getId()== lib.getCate().getId()}? "selected":"">
                               <%= c.getCategoria() %>
                            </option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type ="submit" value ="Enviar"></td>
                    </tr>
            </table>
        </form>
    </body>
</html>
