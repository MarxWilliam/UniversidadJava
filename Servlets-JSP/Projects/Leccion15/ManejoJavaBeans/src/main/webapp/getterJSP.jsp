<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que lee los valores del JavaBean</title>
    </head>
    <body>
        <h1>JSP que lee los valores del JavaBean</h1>
        <jsp:useBean id="retangulo" class="beans.Rectangulo" scope="session" />
        <br>
        Valor base: <jsp:getProperty name="retangulo" property="base" />
        <br>
        Valor altura: <jsp:getProperty name="retangulo" property="altura" />
        <br>
        Valor area: <jsp:getProperty name="retangulo" property="area" />
        <br>
        <br>
        <a href="index.jsp">Regressar al inicio</a>
    </body>
</html>
