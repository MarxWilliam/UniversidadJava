package test;

import datos.PersonaJDBC;
import domain.Persona;
import java.util.List;

public class ManejoPersonas {
    public static void main(String[] args) {
        PersonaJDBC personaJDBC = new PersonaJDBC();
        List<Persona> personas = personaJDBC.select();
        
        for(Persona persona:personas){
            System.out.println(persona.toString());
        }
    
        Persona persona = new Persona();
        persona.setNombre("Maria");
        persona.setApelido("Lara");
        persona.setEmail("mlara@mail.com");
        persona.setTelefono("55668899");

        personaJDBC.insert(persona);
//
//        Persona persona2 = new Persona("Antunes", "Loren", "aloren@mail.com", "995577881299");
//        personaJDBC.insert(persona2);
//
//        Persona persona3 = new Persona("Ronaldo", "Gomes", "rgomes@mail.com", null);
//        personaJDBC.insert(persona3);


//        Persona personaUpdate = new Persona();
//        personaUpdate.setNombre("Mayra");
//        personaUpdate.setApelido("Lara");
//        personaUpdate.setEmail("mlara@mail.com");
//        personaUpdate.setTelefono("55668899");
//        personaUpdate.setId_persona(3);
//        
//        int rows = personaJDBC.update(personaUpdate);
//        System.out.println("Rows: " + rows);


//        Persona persona = new Persona();
//        persona.setId_persona(3);
//        
//        personaJDBC.delete(persona);
        
        personas = personaJDBC.select();

        for(Persona p:personas){
           System.out.println(p.toString());
        }
    }
}
