package br.com.globalmentoring.ejemplocarritocompras.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "CarritoServlet", urlPatterns = {"/CarritoServlet"})
public class CarritoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;carset=UTF-8");

        //Procesamos el nuevo articulo
        String articuloNuevo = request.getParameter("articulo");

        //Creamos o recuperamos la sesion Http
        HttpSession session = request.getSession();

        //Recuperamos la lista de articulos previos
        //si es que existen en la session
        List<String> articulos = (List<String>) session.getAttribute("articulos");
        //Verificamos se la lista de articulos existe
        if (articulos == null) {
            //
            //si no existe iniciamos la lista
            //y la agregamos a la session
            articulos = new ArrayList<>();
            session.setAttribute("articulos", articulos);
        }
        //ya tenemos la lista de articulos lista para trabajar
        //Agregamos el nuevo articulo
        //y lo agregamos por paso por referencia a la lista de articulos
        if (articuloNuevo != null && !articuloNuevo.trim().equals("")) {
            articulos.add(articuloNuevo);
        }
        try (PrintWriter out = response.getWriter()) {
            //Mostramos los articulos totales al cliente
            out.println("<h1>Lista de art&iacute;culos</h1>");
            out.println("<br>");
            //Iteramos todos os articulos, incluyendo el nuevo
            for (String articulo : articulos) {
                out.print("<LI>" + articulo + "</LI>");
            }
            //Agregamos un link para regresar al inicio
            out.println("<br>");
            out.println("<a href='/EjemploCarritoCompras'>Regressar</a>");
            out.close();
        }
    }
}
