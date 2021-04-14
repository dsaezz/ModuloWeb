<%-- 
    Document   : registro
    Created on : 13-04-2021, 19:19:29
    Author     : Diego
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
                <div class="contenedor-registro">
                    <h1>Registrate</h1>
                    <form action="Controlador" method="POST">
                        <input type="text" placeholder="Ingrese rut" name="rut" id="rut" />
                        <input type="text" placeholder="Ingrese nombre" name="nombre" id="nombreR"/>
                        <input type="text" placeholder="Ingrese apellido paterno" name="apellidoP" id="apellidoP" />
                        <input type="text" placeholder="Ingrese apellido materno" name="apellidoM" id="apellidoM" />
                        <input type="text" placeholder="Ingrese direccion" name="direccion" id="direccion" />
                        <input type="email" placeholder="Ingrese email" name="emailR" id="email"/>
                        <input type="password" placeholder="Ingrese password" name="passwordR" id="password" />
                        <center><input class="boton" name="accion" type="submit" value="Registrarse"/></center>
                    </form>
                </div>
            </div>
            <!-- <div class="contenedor-imagen">1</div> -->
        </div>
    </body>
   <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
  <script>
    //const Swal = require("sweetalert2");
    const mostrarAlerta = () => {
      const email = document.getElementById("email").value;
      const password = document.getElementById("password").value;
      if (email == "" && password != "") {
        //alert("El Email es requerido");
        Swal.fire({
          title: "Error!",
          text: "El email es requerido",
          icon: "error",
          confirmButtonText: "Aceptar",
          timer: 5000,
        });
      } else if (email != "" && password == "") {
        // alert("El password es requerido");
        Swal.fire({
          title: "Error!",
          text: "El password es requerido",
          icon: "error",
          confirmButtonText: "Aceptar",
          timer: 5000,
        });
      } else if (email == "" || password == "") {
        //alert("Todos los campos son obligatorios");
        Swal.fire({
          title: "Error!",
          text: "Todos los campos son obligatorios",
          icon: "error",
          confirmButtonText: "Aceptar",
          timer: 5000,
        });
      }
    };
  </script>
</html>