package mx.com.gm.sga.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name="Persona.findAll", query="SELECT p from Persona p ORDER BY p.idPersona")
})

public class Persona implements Serializable{
   
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_persona")
    private int idPersona;
    
    private String nombre;
    
    private String apelido;
    
    private String email;
    
    private String telefono;

    public Persona() {
    }

    public Persona(String nombre, String apelido, String email, String telefono) {
        this.nombre = nombre;
        this.apelido = apelido;
        this.email = email;
        this.telefono = telefono;
    }

 

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apelido=" + apelido + ", email=" + email + ", telefono=" + telefono + '}';
    }
}
