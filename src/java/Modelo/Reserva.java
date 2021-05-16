/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;
/**
 *
 * @author dsaez
 */
public class Reserva {

    int ID, hora;
    Date fecha;
    String estado;
    String rutUsuario;
    int IdRol;

    public Reserva() {
    }

    public Reserva(int ID, int hora, Date fecha, String estado, String rutUsuario, int IdRol) {
        this.ID = ID;
        this.hora = hora;
        this.fecha = fecha;
        this.estado = estado;
        this.rutUsuario = rutUsuario;
        this.IdRol = IdRol;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public int getIdRol() {
        return IdRol;
    }

    public void setIdRol(int IdRol) {
        this.IdRol = IdRol;
    }
    
    
    
    
}
