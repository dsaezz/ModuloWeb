/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Blob;

/**
 *
 * @author Diego
 */
public class Plato {
    
    int id;
    String receta;
    Blob imagen;
    int precio;

    public Plato() {
    }

    public Plato(int id, String receta, Blob imagen, int precio) {
        this.id = id;
        this.receta = receta;
        this.imagen = imagen;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public Blob getImagen() {
        return imagen;
    }

    public int getPrecio() {
        return precio;
    }

    public String getReceta() {
        return receta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }
    
    
    
    
    
    
    
    
}