/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import Modelo.Mesa;
import java.sql.CallableStatement;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author Diego
 */
public class MesaDAO {

    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;

    public List listar() {
        List<Mesa> lista = new ArrayList<>();
        String sql = "SELECT * FROM MESA";//"exe LISTARMESA";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mesa m = new Mesa();
                m.setId(rs.getInt(1));
                m.setNr_mesa(rs.getInt(2));
                String variable;
                variable = rs.getString(3);
                char caracter = variable.charAt(0);
                m.setEstado(caracter);
                lista.add(m);
            }
        } catch (Exception e) {

        }
        return lista;

    }

    public List listarDiferente() {
        List<Mesa> lista = new ArrayList<>();
        String sql = "SELECT * FROM MESA";//"exe LISTARMESA";
        try {

            //LLamado del procedimiento al estilo pl/sql
            String sqlP = "{EXECUTE PROCEDURES.LISTARMESA(?)}";
            CallableStatement cs = con.prepareCall(sqlP);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeQuery();
            rs = (ResultSet) cs.getObject(1);

            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
               rs.getInt(1);
                rs.getInt(2);
                //rs.getString(3);
               /* String variable;
                variable = rs.getString(3);
                char caracter = variable.charAt(0);*/
                
            }
        } catch (Exception e) {

        }
        return lista;

    }

}
