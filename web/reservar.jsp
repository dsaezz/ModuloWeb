<%-- 
    Document   : reservar
    Created on : 09-05-2021, 14:43:27
    Author     : dsaez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function activa() {
                document.nombreform.nombreboton.disabled = true;
                document.nombreform.nombreboton.disabled = true;
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
            crossorigin="anonymous"
            />
        <link
            href="css/login.css"
            rel="stylesheet"
            type="text/css"
            media="screen"
            />
        <title>Restaurant</title>
    </head>
    <style>

        h1.titulo{
            text-align: center;
        }

    </style>
    <body>
        <div class="contenedor">
            <div class="contenedor-login">
                <h1 class="titulo">SIGLO XXI</h1>
                <div class="contenedor-reserva">
                    <h1>Registrar Reserva</h1>
                    <% String hidden = request.getParameter("nMesa");%>
                    El valor oculto es <%=hidden%>
                    <%!
                        String numeroMesa;
                    %>
                    <%
                    numeroMesa=request.getParameter("nMesa");%>
                    <h1><%= numeroMesa  %></h1>


                    <form action="SigloXXI?accion=Reservando" method="POST">
                        <!--  <input type="hidden"  name="idMesa" id="idMesa" value="hidden" /><br> -->
                        <label for="fecha">Ingrese fecha de inicio</label>
                        <input type="datetime" placeholder="Ingrese fecha y hora" name="inicio" id="inicio"/><br>
                        <label for="fecha">Ingrese fecha de termino</label>
                        <input type="datetime" placeholder="Ingrese fecha y hora termino" name="termino" id="termino" /><br>
                        <input type="hidden"  name="idCliente" id="idCliente" value="${cliente.getIdCliente()}" /><br>
                        <input
                            type="submit"
                            name="accion"
                            value="Reservar"
                            class="btn btn-primary"
                            />
                        <input
                            type="submit"
                            name="accion"
                            value="Comprobar Reserva"
                            class="btn btn-primary"
                            onclick="asignarMesa.submit()"
                            />
                    </form>
                    <form name="asignarMesa" action="SigloXXI?accion=actualizarReserva" method="POST" hidden="">
                        <input type="hidden"  name="idMesa" id="idMesa" value="<%=numeroMesa%>" /><br>

                    </form>

                </div>
            </div>
            <!-- <div class="contenedor-imagen">1</div> -->
        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>

</html>
