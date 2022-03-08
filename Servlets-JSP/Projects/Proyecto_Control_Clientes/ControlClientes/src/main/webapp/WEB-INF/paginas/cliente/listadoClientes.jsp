<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="pt_BR"/>

<section id="clientes">
    
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Clientes</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Saldo</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Iteramos cada elemento de la lista de clientes-->
                            <c:forEach var="cliente" items="${clientes}">
                                <tr>
                                    <td>${cliente.idCliente}</td>
                                    <td>${cliente.nombre} ${clliente.apelido}</td>
                                    <td><fmt:formatNumber value="${cliente.saldo}" type="currency"/></td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accioneditar&idCliente=${cliente.idCliente}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- Inicio Targetas para los totales -->
            <div class="card texxt-center bg-danger text-white mb-3">
                <div class="card-body">
                    <h3>Saldo Total</h3>
                    <h4 class="display-5">
                        <fmt:formatNumber value="${saldoTotal}" type="currency"/>
                    </h4>
                    </div>
                    <div class="card text-center bg-success text-white mb-3">
                        <div class="card-body">
                            <h3>Total Clientes</h3>
                            <h4 class=display-4> 
                            <i class="fas fa-users"></i> ${totalClientes}
                            </h4>
                        </div>
                        
                    </div>
            </div>

            <!-- Fin Targetas para los totales -->
        </div>
    
</section>
                            
             
    <!-- Agregar Cliente MODAL -->
    <jsp:include page="agregarCliente2.jsp"/>
    