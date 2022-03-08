package test;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.util.List;

public class Test {
    public static void main(String[] args) {
           List<Cliente> clientes = new ClienteDaoJDBC().listar();
           for(Cliente cliente:clientes){
                System.out.println(cliente);
           }
    }
}
