<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="Modelo.Plato"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Restaurant</title>

        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" type="text/css" media="screen" href="css/css.css" />
    </head>
    <body>
        <% if (session.getAttribute("usuario") == null) {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }%>
            
        <div class="contenedor">
            <jsp:include page="perfil.jsp" />
            <main class="contenido">
                <jsp:include page="header.jsp" />
                <h1 class="titulo">Restaurant</h1>
                <div class="disponible">
                    <c:if test="${platos == null}">
                        
                        <c:forEach var="dato" items="${platos}">
                            <div class="card">
                                <img
                                    src="http://loredomuebles.com/wp-content/uploads/2017/11/MESAS-1080x675.jpg"
                                    class="card-img-top"
                                    alt="imagen-mesa"
                                    />
                                <div class="card-body">
                                    <h5 class="card-title">Plato ${dato.getId()}</h5>
                                    <p class="card-text">
                                        <!--  Some quick example text to build on the card title and make
                                                                    up the bulk of the card's content. -->
                                        Receta: ${dato.getReceta()}.
                                    </p>
                                    <p>
                                        Precio: ${dato.getPrecio()}
                                    </p>

                                    <button
                                        type="button"
                                        class="btn btn-primary"
                                        data-bs-toggle="modal"
                                        data-bs-target="#modal1"
                                        >
                                        Reservar
                                    </button>
                                </div>
                            </div>

                        </c:forEach>
                    </c:if>
                    <div
                        class="modal fade"
                        id="modal1"
                        data-bs-backdrop="static"
                        data-bs-keyboard="false"
                        tabindex="-1"
                        aria-labelledby="staticBackdropLabel"
                        aria-hidden="true"
                        >
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">
                                        Reservar mesa
                                    </h5>
                                    <button
                                        type="button"
                                        class="btn-close"
                                        data-bs-dismiss="modal"
                                        aria-label="Close"
                                        ></button>
                                </div>
                                <div class="modal-body">
                                    ¿Desea reservar la mesa <%= request.getAttribute("mesa")%>?
                                </div>
                                <div class="modal-footer">
                                    <button
                                        type="button"
                                        class="btn btn-secondary"
                                        data-bs-dismiss="modal"
                                        >
                                        Cerrar
                                    </button>
                                    <button type="button" class="btn btn-primary">
                                        Reservar
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </body>
    <script
        src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"
        integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG"
        crossorigin="anonymous"
    ></script>
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"
        integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc"
        crossorigin="anonymous"
    ></script>
</html>
