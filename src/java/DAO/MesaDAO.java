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
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author Diego
 */
public class MesaDAO {

    PreparedStatement ps;
    OracleResultSet rs;
    Conexion c = new Conexion();
    Connection con;
    OracleCallableStatement cst;

    public List listar() {
        List<Mesa> lista = new ArrayList<>();
        String sql = "SELECT * FROM MESA";//"exe LISTARMESA";
        try {
            con = c.conectar();
            cst = (OracleCallableStatement) con.prepareCall("{call LISTARMESA(?)}");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();
            rs = (OracleResultSet) cst.getObject(1);
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

    /* public List listarMesa() {
        List<Mesa> lista = new ArrayList<>();

        try {
            con = c.conectar();
            cst = con.prepareCall("{call OM (?,?,?)}");
            cst.registerOutParameter(1, java.sql.Types.NUMERIC);
            cst.registerOutParameter(2, java.sql.Types.NUMERIC);
            cst.registerOutParameter(3, java.sql.Types.CHAR);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            rs = cst.getResultSet();
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
            cst.close();
        } catch (Exception e) {

        }
        return lista;

    }*/
    public List listarProcedimientos() {
        List<Mesa> lista = new ArrayList<>();

        try {
            con = c.conectar();
            cst = (OracleCallableStatement) con.prepareCall("{call LISTARMESA(?)}");

            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();
            rs = (OracleResultSet) cst.getObject(1);

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
            con.close();

        } catch (Exception e) {

        }
        return lista;

    }

}
