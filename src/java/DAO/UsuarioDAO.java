/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Conexion;
import Modelo.Rol;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class UsuarioDAO {

    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;

    public Usuario login(String correo, String password) {
        Usuario usuario = new Usuario();
        // String sql = "select * from "

        /* String sql = "select rut,nombre,apellido_p,apellido_m,tipo_rol,correo,direccion from usuario ,rol where correo=" +correo+ " and password="+password+" and rol_id_rol = id_rol"; */
        String sql = "select rut,nombre,apellido_p,apellido_m,tipo_rol,correo,direccion from usuario ,rol where correo=" + "'" + correo + "'" + " and clave=" + "'" + password + "'" + " and rol_id_rol = id_rol";

        int r = 0;
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                usuario.setRut(rs.getString(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellido_P(rs.getString(3));
                usuario.setApellido_M(rs.getString(4));
                usuario.setCorreo(rs.getString(6));
                usuario.setDireccion(rs.getString(7));
                r = r + 1;
            }

            // usuario.setPassword(null);
            if (r == 1) {
                return usuario;
            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }

    }

    public void registrar(String rut, String nombre, String apellidoM, String apellidoP, String email, String password, String direccion) {
        
        String sql = "INSERT INTO USUARIO (RUT, NOMBRE, APELLIDO_P, APELLIDO_M, ROL_ID_ROL, CORREO, DIRECCION, CLAVE) VALUES ("+"'"+rut+"'"+", "+"'"+nombre+"'"+", "+"'"+apellidoM+"'"+", "+"'"+apellidoP+"'"+", "+"'"+7+"'"+", "+"'"+email+"'"+", "+"'"+direccion+"'"+", "+"'"+password+"'"+")";
        
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
        
    }

}

