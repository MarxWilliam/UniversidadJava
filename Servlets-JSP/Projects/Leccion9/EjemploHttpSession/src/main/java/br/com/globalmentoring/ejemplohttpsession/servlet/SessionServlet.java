package br.com.globalmentoring.ejemplohttpsession.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SessionServlet", urlPatterns = {"/SessionServlet"})
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String titulo = null;
        
        //Pedimos el atributo e verificamos se existe
        Integer contadorVisitas = (Integer) session.getAttribute("ContadorVisitas");
        
        //Si es igual a nulo, quiere dicir que es la primeira vez que accedemos ao recurso
        if(contadorVisitas == null){
            contadorVisitas = new Integer(1);
            titulo = "Bienvenido por primeira vez...";
        } else {
            //Si es distinto de nulo incrementamos el contador
            titulo = "Bienvenido nuevamente";
            contadorVisitas += 1;
        }
        
        //en cualquier caso agregamos el valor del contado a la session
        session.setAttribute("ContadorVisitas", contadorVisitas);
        
        PrintWriter out = response.getWriter();
        out.println("T&iacute;tulo: " + titulo);
        out.println("<br>");
        out.println("No. accesos al recurso: " + contadorVisitas);
        out.println("<br>");
        out.println("ID de la sesi&oacute;n: " + session.getId());
    }
}