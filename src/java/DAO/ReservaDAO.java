/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Conexion;
import Modelo.MesaService;
import Modelo.ReservaService;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
     public String reservar(int id, String inicio, String termino) {

        /*SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
       String ini = formato.format(inicio);*/
        int res;
        String msj = "";
        try {
            con = c.conectar();

            CallableStatement cmd = con.prepareCall("{call AGREGARRESERVA(?,?,?,?,?,?)}");

            cmd.setInt(1, id);
            cmd.setDate(2, java.sql.Date.valueOf(inicio));
            cmd.setDate(3, java.sql.Date.valueOf(termino));
            cmd.setString(4, "D");
            cmd.setString(5, "1");
            cmd.setString(6, "1");
            //el metodo ve la cantides de filas que fueron afectadas
            res = cmd.executeUpdate();

            if (res == 1) {

                msj = "La reserva se realizo correctamente";

            } else {
                msj = "Error no se pudo agregar";
            }

        } catch (SQLException e) {
            System.out.print("loloololo " + inicio + e);
        }
        return msj;
    }



}
