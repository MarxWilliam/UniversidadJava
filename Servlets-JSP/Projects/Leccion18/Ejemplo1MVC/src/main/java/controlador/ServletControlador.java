package controlador;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Rectangulo;

@WebServlet(name="ServletControlador", urlPatterns={"ServletCcntrolador"})
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        //1. Processamos parametros
        
        //2. Creamos los JavaBeans
        Rectangulo rec = new Rectangulo(3,6);
        
        //3. Agregamos el JavaBean a algum alcance (request, session, aplication)
        request.setAttribute("mensaje", "Saludos desde el Servlet");
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("rectangulo", rec);
        
        //4. Redirecionar a la vista selecionada
        RequestDispatcher rd = request.getRequestDispatcher("vista/desplegarVariables.jsp");
        //Se propagan los objetos request y response
        //para que puedan ser utilizados por el JSP seleccionado
        rd.forward(request, response);
        
        //Ya no se necesita hacer nada mas despues del
        //redireccionamiento, ya que el flujo continua
        //con el JSP
    }
}
