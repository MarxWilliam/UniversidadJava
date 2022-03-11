package ejemplo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IntroduccionJDBC {
    public static void main(String[] args) {
        //Paso . Creamos nuestra cadena de conexion a mysql
        String url = "jdbc:mysql://localhost/test?useSSL=false&useTimezone=true&serverTimezone=UTC";
        
        try {
            //Paso 2. Creamos el objecto de conexion a la base de datos
            Connection conexion;

            conexion = DriverManager.getConnection(url, "developer", "practicing");
            
            //Paso 3. Creamos un objeto statment
            Statement instruccion = conexion.createStatement();
            
            //Paso 4. Creamos el Query
            String sql = "select id_persona, nombre, apelido, email, telefono from persona;";
            //Paso 5. Ejecucion del query
            ResultSet resultado = instruccion.executeQuery(sql);
            //Paso 6. Ejecutamos el resultado
            while(resultado.next()){
                System.out.print("Id Persona: " + resultado.getInt(1));
                System.out.print("  Nombre: " + resultado.getString(2));
                System.out.print("  Apelido: " + resultado.getString(3));
                System.out.print("  Email: " + resultado.getString(4));
                System.out.println("  Telefono: " + resultado.getString(5));
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(IntroduccionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }
}
