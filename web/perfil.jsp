<%-- 
    Document   : perfil
    Created on : 11-04-2021, 4:54:57
    Author     : Diego
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="menu">
  <h1 class="titulo-perfil">Cliente</h1>
  <div class="usuario">
    <div class="imagen-usuario">
      <img
        src="https://w7.pngwing.com/pngs/719/903/png-transparent-avatar-computer-icons-avatar-icon-thumbnail.png"
        alt="imagen-usuario"
        class="mx-auto d-block logo"
      />
    </div>
    <div class="contenido-usuario">
      <p>
        <span>Nombre : </span><span class="datos"> ${cliente.getNombre()}</span>
      </p>
      <p>
        <span>Apellidos : </span
        ><span class="datos"
          >${cliente.getApellido()}</span
        >
      </p>
      <p>
        <span>Email : </span><span class="datos">${cliente.getCorreo()}</span>
      </p>
    </div>
  </div>
</div>