/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Conexion;
import Modelo.Mesa;
import Modelo.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author dsaez
 */
public class ReservaDAO {
    
     PreparedStatement ps;
    OracleResultSet rs;
    Conexion c = new Conexion();
    Connection con;
    OracleCallableStatement cst;

    public List listar() {
        List<Reserva> lista = new ArrayList<>();
        try {
            con = c.conectar();
            cst = (OracleCallableStatement) con.prepareCall("{call LISTARRESERVA(?)}");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();
            rs = (OracleResultSet) cst.getObject(1);
            while (rs.next()) {
                Reserva r = new Reserva();
                r.setID(rs.getInt(1));
                r.setHora(rs.getInt(2));
                r.setFecha(rs.getDate(3));
                r.setEstado(rs.getString(4));
                r.setRutUsuario(rs.getString(5));
                r.setIdRol(rs.getInt(6));
                
                lista.add(r);
            }
        } catch (Exception e) {

        }
        return lista;

    }
    
    
}
