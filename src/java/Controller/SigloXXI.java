/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MesaDAO;
import DAO.PlatoDAO;
import DAO.ReservaDAO;
import DAO.UsuarioDAO;
import Modelo.Mesa;
import Modelo.Plato;
import Modelo.Reserva;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SigloXXI")
public class SigloXXI extends HttpServlet {

    MesaDAO mdao = new MesaDAO();
    UsuarioDAO udao = new UsuarioDAO();
    PlatoDAO pdao = new PlatoDAO();
    ReservaDAO rdao = new ReservaDAO();

    public SigloXXI() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
                    Usuario usuario = udao.login(email, password);

                    if (usuario == null) {
                        //request.getRequestDispatcher("login.jsp").forward(request, response);
                        response.sendRedirect(request.getContextPath() + "/login.jsp");
                    } else {

                        session.setAttribute("usuario", usuario);
                        response.sendRedirect(request.getContextPath() + "/home.jsp");
                    }
                    break;
                case "Reservar":
                    List<Mesa> datos = mdao.listar();
                    //request.setAttribute("datos", datos);

                    session.setAttribute("listarMesa", datos);
                    //request.getRequestDispatcher("listarMesa.jsp").forward(request, response);
                    response.sendRedirect(request.getContextPath() + "/listarMesa.jsp");
                    break;
                case "Reservando":

                    // request.getRequestDispatcher("reservar.jsp").forward(request, response);
                    response.sendRedirect(request.getContextPath() + "/reservar.jsp");
                    break;

                case "Registrarse":

                    String rut = request.getParameter("rut");
                    String nombre = request.getParameter("nombre");
                    String apellidoP = request.getParameter("apellidoP");
                    String apellidoM = request.getParameter("apellidoM");
                    String direccion = request.getParameter("direccion");
                    String emailR = request.getParameter("emailR");
                    String passwordR = request.getParameter("passwordR");
                    udao.registrar(rut, nombre, apellidoM, apellidoP, emailR, passwordR, direccion);
                    response.sendRedirect(request.getContextPath() + "/login.jsp");

                    break;
                case "HOME":
                    List<Plato> platos = pdao.listar();

                    session.setAttribute("platos", platos);
                    //request.getRequestDispatcher("home.jsp").forward(request, response);
                    response.sendRedirect(request.getContextPath() + "/home.jsp");
                    break;
                case "LISTARESERVAS":
                    List<Reserva> re = rdao.listar();
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
