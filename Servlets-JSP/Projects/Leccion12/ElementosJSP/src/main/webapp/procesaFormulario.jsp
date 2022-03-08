<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processa Formulário</title>
    </head>
    <body>
        <h1>Resultado de Processar Formulario</h1>
        Usuario: <%= request.getParameter("usuario")%>
        <br>
        Password: <%= request.getParameter("password")%>
        <br>
        <br>
        <a href="index.html">Regressar al inicio</a>
    </body>
</html>
