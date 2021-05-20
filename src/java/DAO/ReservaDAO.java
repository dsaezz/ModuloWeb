/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Conexion;
import Modelo.Mesa;
import Modelo.ReservaService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    OracleResultSet ors;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;
    OracleCallableStatement cst;

    public List listar() {
        List<ReservaService> lista = new ArrayList<>();
        try {
            con = c.conectar();
            cst = (OracleCallableStatement) con.prepareCall("{call LISTARRESERVA(?)}");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();
            ors = (OracleResultSet) cst.getObject(1);
            while (ors.next()) {
                ReservaService r = new ReservaService();
                r.setID(ors.getInt(1));
                r.setfInicio(ors.getDate(2));
                r.setfTermino(ors.getDate(3));

                String es;
                es = ors.getString(4);
                char estado = es.charAt(0);
                r.setEstado(estado);
                r.setClienteid(ors.getInt(5));

                String ac;
                ac = ors.getString(6);
                char activo = ac.charAt(0);
                r.setActivo(activo);

                lista.add(r);
            }
        } catch (Exception e) {

        }
        return lista;

    }

    public List listaReservas() {

        List<ReservaService> datos = new ArrayList<>();
        String sql = "select * from reserva";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReservaService r = new ReservaService();
                r.setID(rs.getInt(1));
                r.setfInicio(rs.getDate(2));
                r.setfTermino(rs.getDate(3));

                String es;
                es = rs.getString(4);
                char estado = es.charAt(0);
                r.setEstado(estado);
                r.setClienteid(rs.getInt(5));

                String ac;
                ac = rs.getString(6);
                char activo = ac.charAt(0);
                r.setActivo(activo);

                datos.add(r);
            }

        } catch (Exception e) {
        }

        return datos;
    }

    public void reservar(int id, Date inicio, Date termino, char estado, int idCliente, char activo) {

        String sql = "INSERT INTO SIGLOXXI.RESERVA (ID_RESERVA, FHORA_LLEGADA, FHORA_SALIDA, ESTADO_RESERVA, CLIENTE_ID_CLIENTE, ACTIVO) VALUES (" + "'" + id + "'" + ", " + "'" + inicio + "'" + ", " + "'" + termino + "'" + ", " + "'" + estado + "'" + ", " + "'" + idCliente + "'" + ", " + "'" + activo + "'" + ")";

        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ors = (OracleResultSet) ps.executeQuery();
        } catch (Exception e) {
        }

    }

}
