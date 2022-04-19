<%@page import="java.util.ArrayList"%>
<%@page import="clases.Categorias"%>
<%
ArrayList<Categorias> categorias=(ArrayList<Categorias>) session.getAttribute("cates");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#1E8449">
        <center><h1>CATEGORIAS</h1> </center>
        <p><a href="CategoriaController?op=nuevo">Nuevo</a>
            <table border="3">
                <tr>
                    <th>Id</th>
                    <th>Categoria</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>
                <%
                for(Categorias item :categorias){
                %>
                
                <tr>
                    <td><%=item.getId()%></td>
                    <td><%=item.getCategoria()%></td>
                    <td><a href="CategoriaController?op=editar&id=<%= item.getId()%>">Editar</a></td>
                    <td><a href="CategoriaController?op=eliminar&id=<%= item.getId()%>">Eliminar</a></td>

                </tr>
                
                <%
                    }
                %>
            </table>
<p><a href="index.jsp">Ir al Inicio</a></p>
</body>
</html>
