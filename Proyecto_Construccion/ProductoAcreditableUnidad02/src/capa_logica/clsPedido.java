/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa_logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 
 */
public class clsPedido implements Serializable {

    private int idPedido;
    private int idProyecto;
    private String nombreProyecto;
    private Date fecha;
    private boolean estado;
    private ArrayList<clsDetallePedido> detalles = new ArrayList<>();

    public clsPedido(int idPedido, int idProyecto, String nombreProyecto, Date fecha, boolean estado) {
        this.idPedido = idPedido;
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public Date getFecha() {
        return fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public ArrayList<clsDetallePedido> getDetalles() {
        return detalles;
    }

    public void agregarDetalle(clsDetallePedido det) {
        // si ya existe el material, suma cantidad
        for (clsDetallePedido d : detalles) {
            if (d.getIdMaterial() == det.getIdMaterial()) {
                int nueva = d.getCantidad() + det.getCantidad();
                detalles.remove(d);
                detalles.add(new clsDetallePedido(det.getIdMaterial(), det.getNombreMaterial(), det.getCategoria(), det.getCostoUnitario(), nueva));
                return;
            }
        }
        detalles.add(det);
    }

    public double getTotal() {
        double total = 0;
        for (clsDetallePedido d : detalles) {
            total += d.getSubtotal();
        }
        return total;
    }
}
