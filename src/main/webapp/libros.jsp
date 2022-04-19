<%@page import ="clases.Libros"%>
<%@page import ="java.util.List"%>
<% List<Libros> libro= (List<Libros>) session.getAttribute("almacen");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#1E8449" >
    <center><h1>LIBROS</h1></center>
    <p><a href="libroController?op=nuevo">Nuevo</a> </p>
    <table border="3">
        <tr>
            <th>Id</th>
            <th>Titulo</th>
            <th>Autor</th>
            <th>Disponible</th>
            <th>Categoria</th>
            <th>Editar</th>
            <th>Eliminar</th>
        </tr>
        <%if(libro!=null){for(Libros item: libro){%>
        <tr>
            <td><%= item.getId()%></td>
            <td><%= item.getTitulo()%></td>
            <td><%= item.getAutor()%></td>
            <td><%= item.getDisponible()%></td>
            <td><%= item.getCate().getCategoria() %></td>
            <td><a href="libroController?op=editar&id=<%= item.getId()%>">Editar</a></td>
            <td><a href="libroController?op=eliminar&id=<%= item.getId()%>">Eliminar</a></td>
        </tr>        
        <%   }}  %>
    </table>  
    <p><a href="index.jsp">Ir al Inicio</a></p>
    </body>
</html>
