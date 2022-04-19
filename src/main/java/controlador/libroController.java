package controlador;

import clases.Categorias;
import clases.Libros;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "libroController", urlPatterns = {"/libroController"})
public class libroController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = (request.getParameter("op").equals("")) ? "listar" : request.getParameter("op");
        Libros lib = new Libros();
        int id;
        HttpSession ses = request.getSession();
        List<Libros> lista = (List<Libros>) ses.getAttribute("almacen");
        List<Categorias> categoria = (List<Categorias>) ses.getAttribute("cates");
        switch (op) {
            case "nuevo":
                if (lista.size() == 0) {
                    lib.setId(1);
                } else {
                    lib.setId(lista.get(lista.size() - 1).getId() + 1);
                }
                request.setAttribute("categoria", categoria);
                request.setAttribute("lib", lib);
                request.setAttribute("tipo", "new");
                request.getRequestDispatcher("libro-edit.jsp").forward(request, response);
                break;

            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                lib = lista.get(posNodolibro(id, request));
                request.setAttribute("categoria", categoria);
                request.setAttribute("lib", lib);
                request.setAttribute("tipo", "edit");
                request.getRequestDispatcher("libro-edit.jsp").forward(request, response);
                break;

            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                int pos = posNodolibro(id, request);
                lista.remove(pos);
                response.sendRedirect("libros.jsp");
                break;
            case "listar":
                request.setAttribute("almacen", lista);
                response.sendRedirect("libros.jsp");
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String disponible = request.getParameter("disponible");
        int idcat = Integer.parseInt(request.getParameter("idcat"));
        Categorias cate = nodoCategoria(idcat, request);
        String tipo = request.getParameter("tipo");

        Libros c = new Libros();
        c.setId(id);
        c.setTitulo(titulo);
        c.setAutor(autor);
        c.setDisponible(disponible);
        c.setCate(cate);

        HttpSession ses = request.getSession();
        List<Libros> almacen = (List<Libros>) ses.getAttribute("almacen");

        if (tipo.equals("new")) {
            almacen.add(c);
        } else {
            almacen.set(posNodolibro(id, request), c);
        }
        response.sendRedirect("libros.jsp");

    }

    public int posNodolibro(int id, HttpServletRequest request) {
        int index = -1;

        HttpSession ses = request.getSession();
        List<Libros> lista = (List<Libros>) ses.getAttribute("almacen");
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                index = i;
                break;

            }
        }
        return index;
    }

    public Categorias nodoCategoria(int id, HttpServletRequest request) {
        Categorias aux = new Categorias();
        HttpSession ses = request.getSession();
        List<Categorias> lista = (List<Categorias>) ses.getAttribute("cates");
        for (Categorias obj : lista) {
            if (obj.getId() == id) {
                aux = obj;
                break;
            }
        }
        return aux;
    }

    public int posNodoCategoria(int id, HttpServletRequest request) {
        int index = -1;
        HttpSession ses = request.getSession();
        List<Categorias> lista = (List<Categorias>) ses.getAttribute("cates");
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                index = i;
                break;

            }
        }
        return index;
    }

}
