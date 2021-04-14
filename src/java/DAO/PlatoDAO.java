/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Conexion;
import Modelo.Plato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class PlatoDAO {

    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;

    public List listar() {

        List<Plato> lista = new ArrayList<>();
        String sql = "select id_plato,receta,imagen_plato,precio from plato";

        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //int r = 0;
            while (rs.next()) {
                Plato plato = new Plato();
                plato.setId(rs.getInt(1));
                //plato.setImagen(rs.getBlob(2));
                //plato.setPrecio(rs.getInt(3));
                //plato.setReceta(rs.getString(4));
                plato.setReceta(rs.getString(2));
                plato.setPrecio(rs.getInt(4));
                lista.add(plato);
                //r = r + 1;
            }

           // if (r == 0) {
               // return null;
            //} else {
               // return lista;
           // }

        } catch (Exception e) {
           // return null;

        }
        
        return lista;
    }

}
