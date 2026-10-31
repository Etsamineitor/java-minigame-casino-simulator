/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa_logica;

import java.io.Serializable;

/**

 */
public class clsMaterial implements Serializable {

    private int codigo;
    private String nombre;
    private String unidad;
    private double costo;
    private int stock;
    private boolean activo;

    public clsMaterial(int codigo, String nombre, String unidad, double costo, int stock, boolean activo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidad = unidad;
        this.costo = costo;
        this.stock = stock;
        this.activo = activo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public double getCosto() {
        return costo;
    }

    public int getStock() {
        return stock;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
