<%-- 
    Document   : scriptlets
    Created on : 16 de out de 2019, 16:32:12
    Author     : Alemao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Scriptlets</title>
    </head>
    <body>
        <h1>JSP con Scriptlets</h1>
        <br>
        <%-- Scriptlets para enviar informacion al navegador --%>
        <%
            out.println("Saludos desde un Scriptlet");
        %>
        <%-- Scriptlets para manipular los objetos implicitos --%>
        <%
             String nombreAplicacion = request.getContextPath();
             out.println("nombre de la aplicacion:" + nombreAplicacion);
        %>
        <br>
        <%-- Scriptlet con codigo condicionado --%>
        <%
            if(session != null && session.isNew()){
        %>
        La SESSION si es nueva
        <%
            } else if(session != null){
        %>
        la session NO es nueva
        <%}%>
        <br>
        <a href="index.html">Regressar al inicio</a>
    </body>
</html>