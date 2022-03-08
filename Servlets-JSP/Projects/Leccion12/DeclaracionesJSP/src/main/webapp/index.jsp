<!-- Agregamos una declaracion de JSP -->

<%!
    //Declaramos una variable con su metodo get
    String usuario = "Alberto";

    public String getUsuario() {
        return this.usuario;
    }

//    public void setUsuario(String usuario) {
//        this.usuario = usuario;
//    }

//Declaramos un contador de visitas
    private int contadorVisitas = 1;

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uso de Declaraciones com JSPs</title>
    </head>
    <body>
        <h1>Uso de Declaraciones com JSPs</h1>Valor usuario por medio del atributo: <%= this.usuario%>
        <br>
        Valor usuario por medio del matodo: <%= this.getUsuario()%>
        <br>
        Contador de Visitas: <%= this.contadorVisitas++%>

        <br>
        <!--
         <form action="/index.jsp" method="post" name="form1">
             Usuario: <input type="text" name="usuario1">
             <input type="submit" value="Enviar">
         </form>
        -->
        <br>

    </body>
</html>
