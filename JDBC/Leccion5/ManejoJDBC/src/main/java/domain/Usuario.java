package domain;

public class Usuario {
    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String password;

    public Usuario() {
    }

    public Usuario(int id, String nome, String sobrenome, String email, String password) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.password = password;
    }
    
    public Usuario(String nome, String sobrenome, String email, String password) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.password = password;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario: " + "id=" + id + ", nome=" + nome + ", Email=" + email + "password=" + password;
    }
    
    
}
