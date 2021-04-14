<%-- 
    Document   : header
    Created on : 11-04-2021, 4:48:59
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header>
  <nav>
    <ul>
      <!--  <li><a href="home.jsp" class="btn btn-primary">HOME</a></li> -->
      <li>
        <form action="Controlador" method="POST">
          <input
            type="submit"
            name="accion"
            value="HOME"
            class="btn btn-primary"
          />
        </form>
      </li>
      <!-- <li><a href="listarMesa.jsp" class="btn btn-primary">RESERVAR</a></li> -->
      <li>
        <form action="Controlador" method="POST">
          <input
            type="submit"
            name="accion"
            value="RESERVAR"
            class="btn btn-primary"
          />
        </form>
      </li>
      <li><a href="" class="btn btn-primary">CARTA</a></li>
      <li><a href="" class="btn btn-primary">DELÍVERY</a></li>

      <li>
        <form action="Controlador" method="POST">
          <input
            type="submit"
            name="accion"
            value="Cerrar sesion"
            class="btn btn-danger"
          />
        </form>
      </li>
    </ul>
  </nav>
</header>

