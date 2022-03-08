/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.globalmentoring.ejemploredireccionamiento.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alemao
 */
@WebServlet(name = "RedireccionamientoServlet", urlPatterns = {"/RedireccionamientoServlet"})
public class RedireccionamientoServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //ya no utilizamos el objeto PrintWriter para mandar la respuesta. Utilizamos el Redireccionamiento
        String url = null;
        String tipoNavegador = request.getHeader("User-Agent");
        System.out.println("tipo Navegador: " + tipoNavegador);
        if(tipoNavegador!=null && tipoNavegador.contains("Trident")){
            url = "http://www.microsoft.com";
        } else if(tipoNavegador!=null && tipoNavegador.contains("Fireforx")){
            url = "http://www.firefox.com";
        } else if(tipoNavegador!=null && tipoNavegador.contains("Chrome")){
            url="http://www.google.com";
        }
        
        //Redirecionamos al URL seleccionada
        response.sendRedirect(url);
    }
}
