/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClienteDAO;
import DAO.MesaDAO;
import DAO.PlatoDAO;
import DAO.ReservaDAO;
import DAO.UsuarioDAO;
import Modelo.Cliente;
import Modelo.Plato;
import Modelo.ReservaService;
import Modelo.Usuario;
import WebServiceCliente.Mesa;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SigloXXI")
public class SigloXXI extends HttpServlet {

    int idMesa;
    MesaDAO mdao = new MesaDAO();
    UsuarioDAO udao = new UsuarioDAO();
    PlatoDAO pdao = new PlatoDAO();
    ReservaDAO rdao = new ReservaDAO();
    ClienteDAO cdao = new ClienteDAO();
    ReservaService rs = new ReservaService();
    // List<Mesa> m = mdao.listar();
    String mensaje;

    public SigloXXI() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String accion = request.getParameter("accion");
        try {
            switch (accion) {
                case "irLogin":
                    response.sendRedirect(request.getContextPath() + "/login.jsp");
                    break;
                case "irReserva":

//                    
                    session.setAttribute("mesaid", Integer.parseInt(request.getParameter("mesaid")));
                    response.sendRedirect(request.getContextPath() + "/reservar.jsp");

                    break;

                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String accion = request.getParameter("accion");
        try {
            switch (accion) {

                case "Ingresar":
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    Cliente cliente = cdao.login(email, password);

                    if (cliente == null) {
                        //request.getRequestDispatcher("login.jsp").forward(request, response);
                        response.sendRedirect(request.getContextPath() + "/login.jsp");
                    } else {

                        session.setAttribute("cliente", cliente);
                        response.sendRedirect(request.getContextPath() + "/home.jsp");
                    }
                    break;
                case "Reservar":
                    //   List<Mesa> datos = mdao.listar();
                    //request.setAttribute("datos", datos);

                    // session.setAttribute("listarMesa", datos);
                    //request.getRequestDispatcher("listarMesa.jsp").forward(request, response);
                    response.sendRedirect(request.getContextPath() + "/listarMesa.jsp");
                    break;
                case "Reservando":
                    //  int idMesa = Integer.parseInt(request.getParameter("idMesa"));
                    int idCliente = Integer.parseInt(request.getParameter("idCliente"));
                    String inicio = request.getParameter("inicio");
                    String termino = request.getParameter("termino");
                    rs.agregar(inicio, termino, idCliente);

                    break;
                case "actualizarReserva":
                    idMesa = Integer.parseInt(request.getParameter("idMesa"));
                    int ultimoIdReserva = rs.obtenerIdReserva();
                    rs.asignarMesa(idMesa, ultimoIdReserva);
                    response.sendRedirect(request.getContextPath() + "/verReserva.jsp");
                    break;
                case "irReserva":

//                    String email = request.getParameter("email");
//                    String password = request.getParameter("password");
//                    Cliente cliente = cdao.login(email, password);
//                       if (cliente == null) {
//                        //request.getRequestDispatcher("login.jsp").forward(request, response);
//                        response.sendRedirect(request.getContextPath() + "/login.jsp");
//                    } else {
//
//                        session.setAttribute("cliente", cliente);
//                        response.sendRedirect(request.getContextPath() + "/home.jsp");
//                    }
                    //int id = Integer.parseInt(request.getParameter("id"));
                    //Mesa mesa = mdao.mesaId(id);
                    session.setAttribute("mesaid", request.getParameter("id"));
                    // request.getRequestDispatcher("reservar.jsp").forward(request, response);
                    response.sendRedirect(request.getContextPath() + "/reservar.jsp");
                    // ms = mdao.listar();
                    // idMesa = Integer.parseInt(request.getParameter("nMesa"));

                    break;
                case "Registrarse":

                    String rut = request.getParameter("rut");
                    String nombre = request.getParameter("nombre");
                    String apellido = request.getParameter("apellido");
                    String correo = request.getParameter("correo");
                    String direccion = request.getParameter("direccion");
                    String pass = request.getParameter("pass");
                    cdao.registrar(rut, nombre, apellido, correo, direccion, pass);
                    mensaje = "Registro exitoso!";
                    session.setAttribute("mensaje", mensaje);

                    break;

                case "HOME":
                    List<Plato> platos = pdao.listar();

                    session.setAttribute("platos", platos);
                    //request.getRequestDispatcher("home.jsp").forward(request, response);
                    response.sendRedirect(request.getContextPath() + "/home.jsp");
                    break;
                case "LISTARESERVAS":
                    List<ReservaService> re = rdao.listaReservas();
                    session.setAttribute("listaReserva", re);
                    //request.getRequestDispatcher("verReserva.jsp").forward(request, response);
                    response.sendRedirect(request.getContextPath() + "/verReserva.jsp");
                    break;
                case "Cerrar sesion":
                    request.getSession().invalidate();
                    response.sendRedirect(request.getContextPath() + "/login.jsp");
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
