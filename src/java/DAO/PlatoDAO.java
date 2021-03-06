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
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author Diego
 */
public class PlatoDAO {

    
    PreparedStatement ps;
    OracleResultSet rs;
    Conexion c = new Conexion();
    Connection con;
    OracleCallableStatement cst;

    public List listar() {
        List<Plato> lista = new ArrayList<>();
        //String sql = "SELECT * FROM MESA";//"exe LISTARMESA";
        try {
            con = c.conectar();
            cst = (OracleCallableStatement) con.prepareCall("{call LISTARPLATO(?)}");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();
            rs = (OracleResultSet) cst.getObject(1);
            while (rs.next()) {
                Plato p = new Plato();
                p.setId(rs.getInt(1));
                p.setImagen(rs.getBLOB(2));
                p.setPrecio(rs.getInt(3));
                p.setReceta(rs.getString(3));
                lista.add(p);
            }
        } catch (Exception e) {

        }
        return lista;

    }


}
