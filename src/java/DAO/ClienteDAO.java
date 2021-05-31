/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Conexion;
import Modelo.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dsaez
 */
public class ClienteDAO {

    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;
    private Object ex;

    public Cliente login(String correo, String password) {
        Cliente cliente = new Cliente();

        String sql = "select ID_CLIENTE, RUT, NOMBRE, APELLIDO, CORREO, DIRECCION, ACTIVO from SIGLOXXI.CLIENTE where CORREO=" + "'" + correo + "'" + " and CLAVE=" + "'" + password + "'" + " and ID_CLIENTE = ID_CLIENTE";
       
        int r = 0;
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
                cliente.setRut(rs.getString(2));
                cliente.setNombre(rs.getString(3));
                cliente.setApellido(rs.getString(4));
                cliente.setCorreo(rs.getString(5));
                cliente.setDireccion(rs.getString(6));
                String variable;
                variable = rs.getString(7);
                char caracter = variable.charAt(0);
                cliente.setActivo(caracter);
                r = r + 1;
            }

            // usuario.setPassword(null);
            if (r == 1) {
                return cliente;
            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }

    }

    public void registrar(String rut, String nombre, String apellido, String correo, String direccion, String pass) {

        try {
            con = c.conectar();
            // ps = con.prepareStatement(sql);

            CallableStatement cmd = con.prepareCall("{call AGREGARCLIENTE(?,?,?,?,?,?,?)}");

            cmd.setString(1, rut);
            cmd.setString(2, nombre);
            cmd.setString(3, apellido);
            cmd.setString(4, correo);
            cmd.setString(5, direccion);
            cmd.setString(6, pass);
            cmd.setString(7, "1");
            cmd.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
