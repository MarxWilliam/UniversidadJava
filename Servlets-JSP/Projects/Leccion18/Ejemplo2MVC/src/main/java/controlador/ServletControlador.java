package controlador;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Rectangulo;

@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    //1. En este caso no hay necesidad de procesar parametros
    String accion = request.getParameter("accion");
    
    //2. Creamos los JavaBeans
    Rectangulo recRequest = new Rectangulo(1, 2);
    Rectangulo recSesion = new Rectangulo(3, 4);
    Rectangulo recAplicacion = new Rectangulo(5, 6);
    
    

    //3. Agregamos las variables en cierto alcance
    
    //revisamos la accion proporcionada
    if("agregarVariables".equals(accion)){
        //Alcance Request
        request.setAttribute("rectanguloRequest", recRequest);
        //Alcance Session
        HttpSession sesion = request.getSession();
        sesion.setAttribute("rectanguloSesion", recSesion);
        
        //AlcanceApplication
        ServletContext application = this.getServletContext();
        application.setAttribute("rectanguloAplicacion", recAplicacion);
        
        //Agregamos un mensaje
        request.setAttribute("mensaje", "Las variables fueron agregadas");
        
        //4. redirecionamos al JSP de index
        request.getRequestDispatcher("index.jsp").forward(request, response);
    } else if("listarVariables".equals(accion)){
        //4. redirecionamos al jsp que despliega las variables
        request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(request, response);
    } else {
        //4. redirecionamos a la pagina de inicio
        request.setAttribute("mensaje", "Acion no proporcionado o desconocida");
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
        //Esta linea no agregaria informacion ao JSP,
        //ya que no propaga los objetos request e response
        //response.sendRediredt("index.jsp");
    }
  }

}
