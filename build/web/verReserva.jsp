<%-- 
    Document   : verReserva
    Created on : 09-05-2021, 2:49:12
    Author     : dsaez
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" media="screen" href="css/css.css"/>
        <title>Ver reserva</title>
    </head>
    <style>
        table.table, thead.table,tbody.table{
            border:2px solid #02adb5;
        }
        table {
            padding:20px;
        }

    </style>
    <body>
  <% if (session.getAttribute("cliente") == null) {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }%>
        <div class="contenedor">
            <jsp:include page="perfil.jsp" />
            <main class="contenido">
                <jsp:include page="header.jsp" />
                <h1 class="titulo">Tus Reservas</h1>

                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">FECHA Y HORA INICIO</th>
                            <th scope="col">FECHA Y HORA TERMINO</th>
                            <th scope="col">ESTADO</th>
                            <th scope="col">CLIENTE</th>
                            <th scope="col">ACTIVO</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="r" items="${listaReserva}">

                            <tr>
                                <td>${r.getID()}</td>
                                <td>${r.getfInicio()}</td>
                                <td>${r.getfTermino()}</td>
                                <td>${r.getEstado()}</td>
                                <td>${r.getClienteid()}</td>
                                <td>${r.getActivo()}</td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
            </main>
        </div>
    </body>
</html>
