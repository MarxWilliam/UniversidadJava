<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hola Mundo JSP</title>
    </head>
    <body>
        <h1>Ejercicio de Hola Mundo con JSPs</h1>
        <!--Impression de cadenas con diferentes tecnologias -->
        <ul>
            <li>Hola Mundo com HTML</li>
            <li><% out.println("Hola Mundo con Scriptlets");%></li>
            <li>${"Hola mundo con Expression Languages (EL)"}</li>
            <li><c:out value="Hola Mundo con JSTL"/></li>
        </ul>
        <!--Algunos valores del lado del servidor-->
        <ul>
            <li><%= new java.util.Date()%></li>
            <li>Nombre del contexto de la aplicaci&oacute;n <%= request.getContextPath() %></li>
            <li>Valor del par&aacute;metro x: <%= request.getParameter("x")%></li>
        </ul>
    </body>
</html>
