package domain;

public class Persona {
    private int id_persona;
    private String nombre;
    private String apelido;
    private String email;
    private String telefono;

    public Persona(){
    
    }
    
    public Persona(int id_persona, String nombre, String apelido, String email, String telefono) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apelido = apelido;
        this.email = email;
        this.telefono = telefono;
    }
    
        public Persona(String nombre, String apelido, String email, String telefono) {
        this.nombre = nombre;
        this.apelido = apelido;
        this.email = email;
        this.telefono = telefono;
    }
    
    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
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
        return "Persona{" + "id_persona=" + id_persona 
                + ", nombre=" + nombre 
                + ", apelido=" + apelido 
                + ", email=" + email 
                + ", telefono=" + telefono + '}';
    }
    
    
}
