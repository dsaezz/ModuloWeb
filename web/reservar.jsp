<%-- 
    Document   : reservar
    Created on : 09-05-2021, 14:43:27
    Author     : dsaez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
                    <form action="Controlador" method="POST">
                        <input type="text" placeholder="Ingrese su Rut" name="rut" id="rut" />
                        <input type="text" placeholder="Ingrese hora" name="hora" id="hora"/>
                        <input type="text" placeholder="Ingrese fecha" name="fecha" id="fecha" />
                        <center><input class="button" name="accion" type="submit" value="RegistrarReserva"/></center>
                    </form>
                </div>
            </div>
            <!-- <div class="contenedor-imagen">1</div> -->
        </div>
    </body>
   <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
 
</html>
