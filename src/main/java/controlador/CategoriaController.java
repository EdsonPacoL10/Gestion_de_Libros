package controlador;

import clases.Categorias;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CategoriaController", urlPatterns = {"/CategoriaController"})
public class CategoriaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = (request.getParameter("op").equals("")) ? "listar" : request.getParameter("op");
        int id;
        Categorias c = new Categorias(0, "");
        HttpSession ses = request.getSession();
        List<Categorias> lista = (List<Categorias>) ses.getAttribute("cates");
        switch (op) {
            case "nuevo":
                if (lista.size() == 0) {
                    c.setId(1);
                } else {
                    c.setId(lista.get(lista.size() - 1).getId() + 1);
                }
                request.setAttribute("item", c);
                request.setAttribute("tipo", "new");
                request.getRequestDispatcher("categorias-edit.jsp").forward(request, response);
                break;

            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                c = buscarNodo(id, request);
                request.setAttribute("item", c);
                request.setAttribute("tipo", "edit");
                request.getRequestDispatcher("categorias-edit.jsp").forward(request, response);
                break;

            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                c = buscarNodo(id, request);
                lista.remove(c);
                response.sendRedirect("categorias.jsp");
                break;
            case "listar":
                request.setAttribute("cates", lista);
                request.getRequestDispatcher("categorias.jsp").forward(request, response);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String categoria = request.getParameter("categoria");
        String tipo = request.getParameter("tipo");
        Categorias c = new Categorias();
        c.setId(id);
        c.setCategoria(categoria);
        HttpSession ses = request.getSession();
        List<Categorias> lista = (List<Categorias>) ses.getAttribute("cates");
        if (tipo.equals("new")) {
            lista.add(c);
        } else {
            int pos = posNodo(id, request);
            lista.set(pos, c);
        }
        response.sendRedirect("categorias.jsp");

    }

    public Categorias buscarNodo(int id, HttpServletRequest request) {
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

    public int posNodo(int id, HttpServletRequest request) {
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
