/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.globalmentoring.tiposnavegadores.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Creamos las variables para processar el tituli y el mesaje de nuestra pagina web
            String titulo = null, mesaje = null;
            //Detectamos el tipo de navegador que hizo la peticion
            String tipoNavegador = request.getHeader("User-Agent");
            System.out.println("Tipo de Navegador: " + tipoNavegador);
            //Verificamos el tipo de navegador y personalizamos el mesaje a enviar
            if (tipoNavegador != null && tipoNavegador.contains("Trident")) {
                titulo = "Navegador Internet Explorer";
                mesaje = "Estas navegando com Internet Explorer";
            } else if (tipoNavegador != null && tipoNavegador.contains("Firefox")) {
                titulo = "Navegador Firefox";
                mesaje = "Estas navegando com Firefox";
            } else if (tipoNavegador != null && tipoNavegador.contains("Chrome")) {
                titulo = "Navegador Chrome";
                mesaje = "Estas navegando com Chrome";
            }
            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + titulo + "</title>");
            out.println("<head>");
            out.println("<body>");
            out.println("<h1>Tipo de Navegador</h1>");
            out.println("<br>");
            out.println(mesaje);
            out.println("<body>");
            out.println("<html>");
        }

    }
}
