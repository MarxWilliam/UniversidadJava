<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul>
    <c:forEach var="cliente" items="${clientes}">
        <li>${cliente.idCliente} ${cliente.nombre} ${cliente.apelido} ${cliente.saldo}</li>
        </c:forEach>
</ul>
