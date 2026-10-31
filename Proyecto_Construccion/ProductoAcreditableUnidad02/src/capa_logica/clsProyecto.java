/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa_logica;

import java.io.Serializable;

/**

 */
public class clsProyecto implements Serializable {

    private int idProyecto;
    private String nombre;
    private String ubicacion;
    private boolean estado;

    public clsProyecto(int idProyecto, String nombre, String ubicacion, boolean estado) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre + " - " + ubicacion;
    }
}
