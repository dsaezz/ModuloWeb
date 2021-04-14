/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Diego
 */
public class Usuario {
    String rut;
    String nombre;
    String Apellido_P;
    String Apellido_M;
    String Rol_Id_Rol;
    String Correo;
    String Direccion;
    String Password;

    public Usuario() {
    }

    public Usuario(String rut, String nombre, String Apellido_P, String Apellido_M, String Rol_Id_Rol, String Correo, String Direccion, String Password) {
        this.rut = rut;
        this.nombre = nombre;
        this.Apellido_P = Apellido_P;
        this.Apellido_M = Apellido_M;
        this.Rol_Id_Rol = Rol_Id_Rol;
        this.Correo = Correo;
        this.Direccion = Direccion;
        this.Password = Password;
    }

    public String getApellido_P() {
        return Apellido_P;
    }

    public String getApellido_M() {
        return Apellido_M;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return Password;
    }

    public String getRol_Id_Rol() {
        return Rol_Id_Rol;
    }

    public String getRut() {
        return rut;
    }

    public void setApellido_P(String Apelldo_P) {
        this.Apellido_P = Apelldo_P;
    }

    public void setApellido_M(String Apellido_M) {
        this.Apellido_M = Apellido_M;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setRol_Id_Rol(String Rol_Id_Rol) {
        this.Rol_Id_Rol = Rol_Id_Rol;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
