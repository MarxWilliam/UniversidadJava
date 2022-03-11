package test;

import datos.Conexion;
import datos.UsuarioJDBC;
import domain.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Testes {

    public static void main(String[] args) {

        UsuarioJDBC usuarioJDBC = new UsuarioJDBC();

        Usuario usuario = new Usuario();
        usuario.setEmail("marxwilliamf@gmail.com");

        if (usuarioJDBC.login(usuario)) {
            System.out.println("Achou Usuario");
            System.out.println(usuario.toString() + "\n\n");
        }

//        Usuario userInsert = new Usuario("Fernanda", "Arraujo", "fearraujo@gmail.com", "farraujo");
//        int rows = usuarioDB.insert(userInsert);
//        System.out.println("Rows affected: " + rows);
//        Usuario WiUser = new Usuario(2, null, null, null, "WiAlemonUserKey");
//        usuarioDB.update(WiUser);
//        Usuario delUsuario = new Usuario();
//        delUsuario.setId(4);
//        usuarioDB.delete(delUsuario);
        System.out.println("Lista de Usuarios: ");
        List<Usuario> lista = usuarioJDBC.select();
        for (Usuario user : lista) {
            System.out.println(user.toString());
        }

        System.out.println("\n\nConexão Transaccional");

        Connection conexao = null;

        try {
            conexao = Conexion.getConnection();

            try {
                if (conexao.getAutoCommit()) {
                    conexao.setAutoCommit(false);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

            UsuarioJDBC userTransactional = new UsuarioJDBC(conexao);

            Usuario usuario2 = new Usuario();
            usuario2.setEmail("marxwilliamf@gmail.com");

            if (userTransactional.login(usuario2)) {
                System.out.println("Achou Usuario");
                System.out.println(usuario.toString() + "\n\n");
            }

            Usuario userInsert = new Usuario("Kásia", "Borges", "kassiaborges@gmail.com", "KBorges369");
            int rows = userTransactional.insert(userInsert);
            System.out.println("Rows affected: " + rows);

            Usuario WiUser = new Usuario(2, null, null, null, "WiAlemonUserKey2");
            userTransactional.update(WiUser);

            Usuario delUsuario = new Usuario();
            delUsuario.setId(4);
            userTransactional.delete(delUsuario);

            System.out.println("Lista de Usuarios: ");
            lista = userTransactional.select();
            for (Usuario user : lista) {
                System.out.println(user.toString());
            }
            conexao.commit();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                conexao.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace(System.out);
            }
            System.out.println("Rollback Efetuado");

        }

    }
}
