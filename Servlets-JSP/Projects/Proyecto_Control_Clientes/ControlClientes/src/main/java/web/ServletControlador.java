package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("\n\nTeste println\n\n");
        
       List<Cliente> clientes = new ClienteDaoJDBC().listar();
       System.out.println("Clientes: " + clientes);
       request.setAttribute("clientes", clientes);
       request.setAttribute("totalClientes", clientes.size());
       request.setAttribute("saldoTotal", this.calculaSaldoTotal(clientes));
       request.getRequestDispatcher("clientes.jsp").forward(request, response);
   }

    private double calculaSaldoTotal(List<Cliente> clientes){
        double saldoTotal = 0;
        for(Cliente cliente:clientes){
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }
}
