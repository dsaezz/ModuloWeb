/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author dsaez
 */
public class Cliente {

    int idCliente;
    String rut, nombre, apellido, correo, direccion, clave;
    char activo;

    public Cliente() {
    }

    public Cliente(int idCliente, String rut, String nombre, String apellido, String correo, String direccion, String clave, char activo) {
        this.idCliente = idCliente;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.clave = clave;
        this.activo = activo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", direccion=" + direccion + ", clave=" + clave + ", activo=" + activo + '}';
    }
    
    
}
