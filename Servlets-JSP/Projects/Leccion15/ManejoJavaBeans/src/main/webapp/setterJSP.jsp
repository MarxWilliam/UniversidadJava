<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jsp que modifica a un JavaBean</title>
    </head>
    <body>
        <h1>Jsp que modifica aun JavaBean</h1>
        <jsp:useBean id="retangulo" class="beans.Rectangulo" scope="session" />
        Modificamos los atributos
        <br>
        <br>
        <%
            int baseValor = 5;
            int alturaValor = 10;
        %>
        
        <jsp:setProperty name="retangulo" property="base" value="<%= baseValor%>" />
        <jsp:setProperty name="retangulo" property="altura" value="<%= alturaValor%>" />
        <br>
        Nuevo valor base: <%= baseValor%>
        <br>
        Novo valor altura: <%= alturaValor%>
        <br>
        <br>
        <a href="index.jsp">Regressar al inicio</a>
    </body>
</html>