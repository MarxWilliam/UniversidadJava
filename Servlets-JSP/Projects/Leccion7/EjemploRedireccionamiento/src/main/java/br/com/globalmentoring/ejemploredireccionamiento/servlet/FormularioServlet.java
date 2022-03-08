package br.com.globalmentoring.ejemploredireccionamiento.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FormularioServlet", urlPatterns = {"/FormularioServlet"})
public class FormularioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //simulando valores
        String usuarioCorecto = "Juan";
        String passCorecto = "123";
        
        String pUsuario = request.getParameter("usuario");
        String pPassword = request.getParameter("password");
        if(usuarioCorecto.equals(pUsuario) && pPassword.equals(pPassword)){
            out.println("<h1>");
            out.println("Datos Correctos");
            out.println("<br>Usuario: " + pUsuario);
            out.println("<br>Password: " + pPassword);
            out.println("<h1>");
        } else {
            //respondemos ao navegador con un codigo de estado de No Autorizado
            response.sendError(response.SC_UNAUTHORIZED, "Las credenciales son incorrectas");
        }
        //Listado de codigo de error
        //http://docstore.mik.ua/orelly/java-ent/servlet/appc_01.htm
        out.close();
    }
}
