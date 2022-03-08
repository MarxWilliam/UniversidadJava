package br.com.globalmentoring.manejocookies.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "CookiesServlet", urlPatterns={"/CookiesServlet"})
public class CookiesServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Suponemos que el usuario esta visitando por primeira vez nostro sitio
        boolean nuevoUsuario = true;
        //Obtenemos todas las cookies
        Cookie[] cookies = request.getCookies();
        
        //Buscamos se ya existe una cookie creada con anterioridad
        //llamada visitanteRecuriente
        if(cookies!=null){
            for(Cookie c:cookies){
                if(c.getName().equals("VisitanteRecuriente") && c.getValue().equals("si")){
                    //en caso de que ya exista una cookie indicando que ya existe un usuario registrado
                    //con anterioridad ponemos la bandera en falso e salimos del ciclo
                    nuevoUsuario = false;
                    break;
                }
            }//fin del for
        }//fin del if
        //revisamos se el usuario es un novo visitante
        String mensaje = null;
        if(nuevoUsuario){
            //En caso de ser un usuario nuevo creamos el objeto cookie
            Cookie visitanteCookie = new Cookie("VisitanteRecuriente", "si");
            //Agregamos la cookie em la respuesta
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio";
        } else {
            mensaje = "Gracias por visitar NUEVAMENTE nuestro sitio";
        }
        //escribimos la salida
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //Omitimos código HTML para simplificar el código
        out.println("Mensaje: " + mensaje);
    }
}