/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.globalmentoring.cabecerosrespuesta.servlet;

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
@WebServlet(name = "GeneracionExcelServlet", urlPatterns = {"/GeneracionExcelServlet"})
public class GeneracionExcelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            //Especificamos el tipo del documento de respuesta (MIME);
            response.setContentType("aplication/vnd.ms.excel");
            response.setHeader("Content-Disposition", "atachment; filename=excelExemplo.xls");
            //para un uso mas profficional del excel usar: https://poi.apace.org/
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setDateHeader("Expires", -1);
            //desplegamos el contenido en um excel
            //Simplemente modificando el contentType
            out.println("\tValores");
            out.println("\t1");
            out.println("\t2");
            out.println("Total \t=SUMA(B2:B3)");
        }
    }
}
