package br.com.alemao.login.dao;

import java.sql.*;

public class Conexao {
    private static final String DB_URL = "jdbc:mysql://localhost/login?useSSL=false&useTimezone=true&serverTimezone=UTC";
    private static final String DB_USER = "developer";
    private static final String DB_PASSWORD = "practicing";
    
    public static Connection getConexao(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return con;
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
