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
import java.util.Date;
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
                r.setfInicio(rs.getDate(2));
                r.setfTermino(rs.getDate(3));
                
                String es;
                es = rs.getString(4);
                char estado = es.charAt(0);
                r.setEstado(estado);
                r.setClienteid(rs.getString(5));

                String ac;
                ac = rs.getString(6);
                char activo = ac.charAt(0);
                r.setEstado(activo);

                lista.add(r);
            }
        } catch (Exception e) {

        }
        return lista;

    }
    
        public void reservar(int id, Date inicio, Date termino, char estado, int idCliente, char activo) {
        
        String sql = "INSERT INTO SIGLOXXI.RESERVA (ID_RESERVA, FHORA_LLEGADA, FHORA_SALIDA, ESTADO_RESERVA, CLIENTE_ID_CLIENTE, ACTIVO) VALUES ("+"'"+id+"'"+", "+"'"+inicio+"'"+", "+"'"+termino+"'"+", "+"'"+estado+"'"+", "+"'"+idCliente+"'"+", "+"'"+activo+"'"+")";
        
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = (OracleResultSet) ps.executeQuery();
        } catch (Exception e) {
        }
        
    }

}
