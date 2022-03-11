package datos;

import domain.PersonaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDaoJDBC implements PersonaDao {
    public Connection conexionTransaccional;
    
    private static final String SQL_SELECT = "Select id_persona, nombre, apelido, email, telefono from persona";
    private static final String SQL_INSERT = "Insert Into persona(nombre, apelido, email, telefono) values(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "Update persona Set nombre=?, apelido=?, email=?, telefono=? where id_persona = ?";
    private static final String SQL_DELETE = "Delete from persona where id_persona=?";

    public PersonaDaoJDBC(){
    }
    
    public PersonaDaoJDBC(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;
    }
    public List<PersonaDTO> select() throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO persona = null;
        
        List<PersonaDTO> personas = new ArrayList<>();
        
        try{
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id_persona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apelido = rs.getString("apelido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                
                persona = new PersonaDTO(id_persona, nombre, apelido, email, telefono);
                personas.add(persona);
            }
        } finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.conexionTransaccional == null){
                Conexion.close(conn);
            }
        }
        return personas;
    }
    
    public int insert(PersonaDTO persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApelido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            
            System.out.println("ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afetados: " + rows);
        } finally{
            Conexion.close(stmt);
            if(this.conexionTransaccional == null){
                Conexion.close(conn);
            }
        }
        return rows;
    }
    
    public int update(PersonaDTO persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows =0;
        
        try{
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApelido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getId_persona());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros atualizados: " + rows);
            
        } finally{
            Conexion.close(stmt);
            if(this.conexionTransaccional == null){
                Conexion.close(conn);
            }
        }
        return rows;
    }

    public int delete(PersonaDTO persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn =  this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecutando Query: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getId_persona());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        } finally{
            Conexion.close(stmt);
            if(this.conexionTransaccional == null){
                Conexion.close(conn);
            }
        }
        return rows;
    }
}
