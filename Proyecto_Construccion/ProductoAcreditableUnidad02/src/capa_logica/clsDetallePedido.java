/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa_logica;

import java.io.Serializable;

/**

 */
public class clsDetallePedido implements Serializable {

    private int idMaterial;
    private String nombreMaterial;
    private String categoria;
    private double costoUnitario;
    private int cantidad;

    public clsDetallePedido(int idMaterial, String nombreMaterial, String categoria, double costoUnitario, int cantidad) {
        this.idMaterial = idMaterial;
        this.nombreMaterial = nombreMaterial;
        this.categoria = categoria;
        this.costoUnitario = costoUnitario;
        this.cantidad = cantidad;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getSubtotal() {
        return costoUnitario * cantidad;
    }
}
