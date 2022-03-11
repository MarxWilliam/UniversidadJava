package beans;

import javax.ejb.Stateless;

@Stateless
public class HolaMundoEjbImpl implements HolaMundoEjbRemote{

    public int sumar(int a, int b) {
       System.out.println("Ejecutendo metodo sumar en el servidor");
       return a + b;
    }
    
}
