/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package capa_presentacion;

import capa_datos.clsMaterialDAO;
import capa_datos.clsPedidoDAO;
import capa_datos.clsProyectoDAO;
import capa_logica.clsDetallePedido;
import capa_logica.clsMaterial;
import capa_logica.clsPedido;
import capa_logica.clsProyecto;
import java.util.Date;

/**
 *
 * @author 
 * Autor:
 * Javier Alonso Quiroga Torres
 */

public class appConstruccion {

    public static void main(String[] args) {
        try {
            javax.swing.UIManager.put("OptionPane.yesButtonText", "Sí");
            javax.swing.UIManager.put("OptionPane.noButtonText", "No");
            javax.swing.UIManager.put("OptionPane.cancelButtonText", "Cancelar");
            javax.swing.UIManager.put("OptionPane.okButtonText", "Aceptar");
        } catch (Exception e) {
        }

        clsMaterialDAO.recuperar();
        clsProyectoDAO.recuperar();
        clsPedidoDAO.recuperar();

        if (clsMaterialDAO.obtener().isEmpty()) {

            clsMaterialDAO.agregar(new clsMaterial(
                    1, "ARENA", "m3", 45.00, 500, true));

            clsMaterialDAO.agregar(new clsMaterial(
                    2, "CEMENTO", "bolsa", 28.50, 300, true));

            clsMaterialDAO.agregar(new clsMaterial(
                    3, "FIERRO", "varillas", 38.00, 200, true));

            clsMaterialDAO.agregar(new clsMaterial(
                    4, "RIPIO", "m3", 40.00, 400, true));

            clsMaterialDAO.grabar();
        }

        if (clsProyectoDAO.obtener().isEmpty()) {

            clsProyectoDAO.agregar(new clsProyecto(
                    1, "VIVIENDAS SAN JOSE", "LIMA", true));

            clsProyectoDAO.agregar(new clsProyecto(
                    2, "CONDOMINIO LOS PINOS", "AREQUIPA", true));

            clsProyectoDAO.agregar(new clsProyecto(
                    3, "RESIDENCIAL EL SOL", "TRUJILLO", true));

            clsProyectoDAO.grabar();
        }

        if (clsPedidoDAO.obtener().isEmpty()) {
            Date hoy = new Date();

            clsPedido pedido1 = new clsPedido(1, 1, "VIVIENDAS SAN JOSE", hoy, true);
            pedido1.agregarDetalle(new clsDetallePedido(1, "ARENA", "m3", 45.00, 10));
            pedido1.agregarDetalle(new clsDetallePedido(2, "CEMENTO", "bolsa", 28.50, 20));
            pedido1.agregarDetalle(new clsDetallePedido(3, "FIERRO", "varillas", 38.00, 5));
            pedido1.agregarDetalle(new clsDetallePedido(4, "RIPIO", "m3", 40.00, 8));

            clsPedido pedido2 = new clsPedido(2, 2, "CONDOMINIO LOS PINOS", hoy, true);
            pedido2.agregarDetalle(new clsDetallePedido(1, "ARENA", "m3", 45.00, 15));
            pedido2.agregarDetalle(new clsDetallePedido(2, "CEMENTO", "bolsa", 28.50, 25));
            pedido2.agregarDetalle(new clsDetallePedido(3, "FIERRO", "varillas", 38.00, 12));
            pedido2.agregarDetalle(new clsDetallePedido(4, "RIPIO", "m3", 40.00, 10));

            clsPedido pedido3 = new clsPedido(3, 3, "RESIDENCIAL EL SOL", hoy, true);
            pedido3.agregarDetalle(new clsDetallePedido(2, "CEMENTO", "bolsa", 28.50, 50));
            pedido3.agregarDetalle(new clsDetallePedido(3, "FIERRO", "varillas", 38.00, 30));

            clsPedidoDAO.agregar(pedido1);
            clsPedidoDAO.agregar(pedido2);
            clsPedidoDAO.agregar(pedido3);

            clsPedidoDAO.grabar();
        }

        java.awt.EventQueue.invokeLater(() -> {
            jdinicioSesion login = new jdinicioSesion(null, true); // modal
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        });
    }
}
