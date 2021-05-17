/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Conexion;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dsaez
 */
public class ClienteDAO {

    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;

    public Cliente login(String correo, String password) {
        Cliente cliente = new Cliente();
        // String sql = "select * from "

        /* String sql = "select rut,nombre,apellido_p,apellido_m,tipo_rol,correo,direccion from usuario ,rol where correo=" +correo+ " and password="+password+" and rol_id_rol = id_rol"; */
        String sql = "select ID_CLIENTE, RUT, NOMBRE, APELLIDO, CORREO, DIRECCION, ACTIVO from SIGLOXXI.CLIENTE where CORREO=" + "'" + correo + "'" + " and CLAVE=" + "'" + password + "'" + " and ID_CLIENTE = ID_CLIENTE";
       // String sql = "select rut,nombre,apellido_p,apellido_m,tipo_rol,correo,direccion from usuario ,rol where correo=" + "'" + correo + "'" + " and clave=" + "'" + password + "'" + " and rol_id_rol = id_rol";

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

    public void registrar(int id, String rut, String nombre, String apellido, String correo, String direccion, String activo, String pass) {
        
        String sql = "INSERT INTO SIGLOXXI.CLIENTE (ID_CLIENTE, RUT, NOMBRE, APELLIDO, CORREO, DIRECCION, CLAVE, ACTIVO) VALUES ("+"'"+id+"'"+", "+"'"+rut+"'"+", "+"'"+nombre+"'"+", "+"'"+apellido+"'"+", "+"'"+correo+"'"+", "+"'"+direccion+"'"+", "+"'"+pass+"'"+", "+"'"+activo+"'"+")";
        
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
        
    }

}
