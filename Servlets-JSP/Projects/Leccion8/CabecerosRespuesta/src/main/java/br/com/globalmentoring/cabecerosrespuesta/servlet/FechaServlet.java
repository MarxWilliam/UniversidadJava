 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.globalmentoring.cabecerosrespuesta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alemao
 */
@WebServlet(name = "FechaServlet", urlPatterns = {"/FechaServlet"})
public class FechaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            response.setContentType("text/html; charset=UTF-8");
            response.setHeader("refresh", "1"); //Dado en segundos
            //Obtenemos la fexha actual y le aplicamos un formato
            Date fecha = new Date();
            //API para utilizar la classe SimpleDateFormat
            //https:doc.oracle.com/javase/8/docs/api/java/text.SimpleDateFormat.html
            
            //SimpleDateFormart formatador  = new SimpleDateFromat("dd 'de' MMMM 'de' yyyy 'a las' HH:mm:ss");
            SimpleDateFormat formatador = new SimpleDateFormat("'Hora actualizada1: ' HH:mm:ss");
            String fechaConFormato = formatador.format(fecha);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FechaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Fecha actualizada" + fechaConFormato + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
