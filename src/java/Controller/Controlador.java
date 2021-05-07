/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import DAO.MesaDAO;
import DAO.PlatoDAO;
import DAO.UsuarioDAO;
import Modelo.Mesa;
import Modelo.Plato;
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

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    MesaDAO mdao = new MesaDAO();
    UsuarioDAO udao = new UsuarioDAO();
    PlatoDAO pdao = new PlatoDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String accion = request.getParameter("accion");
        /*List<Mesa> datos = mdao.listarDiferente();
        request.setAttribute("datos", datos);
        request.getRequestDispatcher("listarMesa.jsp").forward(request, response);*/

        switch (accion) {
            /*  case "Buscar":
                List<Mesa> datos = mdao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("listarMesa.jsp").forward(request, response); */
            //mdao.listar();

            case "Ingresar":
                // Usuario usuario = udao.login(accion, accion)
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                Usuario usuario = udao.login(email, password);

                /* if(usuario != null){
                     request.setAttribute("usuario",usuario);
                      request.getRequestDispatcher("home.jsp").forward(request, response);
                } */
                // request.setAttribute("usuario",usuario);
                //request.getRequestDispatcher("home.jsp").forward(request, response); 
                if (usuario == null) {
                    //request.getRequestDispatcher("login.jsp").forward(request, response);
                    response.sendRedirect(request.getContextPath() + "/login.jsp");
                } else {

                    session.setAttribute("usuario", usuario);
                    response.sendRedirect(request.getContextPath() + "/home.jsp");
                }
                break;
            case "RESERVAR":
                List<Mesa> datos = mdao.listar();
                //request.setAttribute("datos", datos);

                session.setAttribute("datos", datos);
                request.getRequestDispatcher("listarMesa.jsp").forward(request, response);
                //response.sendRedirect(request.getContextPath() + "/login.jsp");
                break;
            case "Reservar mesa":
                if (request.getParameter("Reservar mesa") != null) {

                    session.setAttribute("idMesa", Integer.parseInt(request.getParameter("idEliminar")));
                    request.getRequestDispatcher("listarMesa.jsp").forward(request, response);
                    break;
                }
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
                //request.setAttribute("datos", datos);

                session.setAttribute("platos", platos);
                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
            case "Cerrar sesion":
                request.getSession().invalidate();
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                break;
            default:
                throw new AssertionError();
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
