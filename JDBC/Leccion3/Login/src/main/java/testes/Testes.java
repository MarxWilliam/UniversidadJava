package testes;

import br.com.alemao.login.dao.UsuarioDB;
import br.com.alemao.login.model.Usuario;
import java.util.List;

public class Testes {

    public static void main(String[] args) {

        UsuarioDB usuarioDB = new UsuarioDB();

        Usuario usuario = new Usuario();
        usuario.setEmail("marxwilliamf@gmail.com");

        if (usuarioDB.login(usuario)) {
            System.out.println("Achou Usuario");
            System.out.println(usuario.toString() + "\n\n");
        }
        
        Usuario userInsert = new Usuario("Fernanda", "Arraujo", "fearraujo@gmail.com", "farraujo");
        int rows = usuarioDB.insert(userInsert);
        System.out.println("Rows affected: " + rows);
        
//        Usuario WiUser = new Usuario(2, null, null, null, "WiAlemonUserKey");
//        usuarioDB.update(WiUser);
        
        Usuario delUsuario = new Usuario();
        delUsuario.setId(4);
        usuarioDB.delete(delUsuario);

        System.out.println("Lista de Usuarios: ");
        List<Usuario> lista = usuarioDB.select();
        for (Usuario user : lista) {
            System.out.println(user.toString());
        }
    }
}
