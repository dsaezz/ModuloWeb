/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import WebServiceCliente.WSServicios_Service;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dsaez
 */
public class ReservaService {

    int ID;
    Date fInicio, fTermino;
    char estado;
    int clienteid;
    char activo;

    public ReservaService() {
    }

    public java.util.List<WebServiceCliente.Reserva> listar() {
        WebServiceCliente.WSServicios_Service service = new WebServiceCliente.WSServicios_Service();
        WebServiceCliente.WSServicios port = service.getWSServiciosPort();
        return port.listarReserva();
    }
    
    public String agregar(int id, java.lang.String inicio,java.lang.String termino , int idCliente){
        WebServiceCliente.WSServicios_Service service = new WebServiceCliente.WSServicios_Service();
        WebServiceCliente.WSServicios port = service.getWSServiciosPort();
        return port.agregarReserva(id, inicio, termino, idCliente);
    }
    

    public ReservaService(int ID, Date fInicio, Date fTermino, char estado, int clienteid, char activo) {
        this.ID = ID;
        this.fInicio = fInicio;
        this.fTermino = fTermino;
        this.estado = estado;
        this.clienteid = clienteid;
        this.activo = activo;
    }

    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getfInicio() {
        return fInicio;
    }

    public void setfInicio(Date fInicio) {
        this.fInicio = fInicio;
    }

    public Date getfTermino() {
        return fTermino;
    }

    public void setfTermino(Date fTermino) {
        this.fTermino = fTermino;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Reserva{" + "ID=" + ID + ", fInicio=" + fInicio + ", fTermino=" + fTermino + ", estado=" + estado + ", clienteid=" + clienteid + ", activo=" + activo + '}';
    }

}
