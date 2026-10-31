/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa_datos;

import capa_logica.clsDetallePedido;
import capa_logica.clsPedido;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**

 */
public class clsPedidoDAO {

    private static ArrayList<clsPedido> pedidos = new ArrayList<>();

    private static final String CARPETA = "src/Construccion";
    private static final String ARCHIVO = CARPETA + File.separator + "pedidos.dat";

    public static void agregar(clsPedido p) {
        pedidos.add(p);
    }

    public static ArrayList<clsPedido> obtener() {
        return pedidos;
    }

    public static int posicion(int idPedido) {
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getIdPedido() == idPedido) {
                return i;
            }
        }
        return -1;
    }

    public static clsPedido buscar(int idPedido) {
        int pos = posicion(idPedido);
        return (pos == -1) ? null : pedidos.get(pos);
    }

    public static int siguienteId() {
        int max = 0;
        for (clsPedido p : pedidos) {
            if (p.getIdPedido() > max) {
                max = p.getIdPedido();
            }
        }
        return max + 1;
    }

    public static ArrayList<clsPedido> listarPorProyecto(int idProyecto) {
        ArrayList<clsPedido> lista = new ArrayList<>();
        for (clsPedido p : pedidos) {
            if (p.getIdProyecto() == idProyecto && p.isEstado()) {
                lista.add(p);
            }
        }
        return lista;
    }

    public static double totalGastadoProyecto(int idProyecto) {
        double total = 0;
        for (clsPedido p : pedidos) {
            if (p.getIdProyecto() == idProyecto && p.isEstado()) {
                total += p.getTotal();
            }
        }
        return total;
    }

    public static ArrayList<clsPedido> listarPedidosQueContienenMaterial(int idMaterial) {
        ArrayList<clsPedido> lista = new ArrayList<>();
        for (clsPedido p : pedidos) {
            if (!p.isEstado()) {
                continue;
            }

            for (clsDetallePedido d : p.getDetalles()) {
                if (d.getIdMaterial() == idMaterial) {
                    lista.add(p);
                    break;
                }
            }
        }
        return lista;
    }

    public static void grabar() {
        try {
            File carpeta = new File(CARPETA);
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO));
            oos.writeObject(pedidos);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error al grabar pedidos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static void recuperar() {
        try {
            File f = new File(ARCHIVO);
            if (f.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                pedidos = (ArrayList<clsPedido>) ois.readObject();
                ois.close();
            } else {
                pedidos = new ArrayList<>();
            }
        } catch (Exception e) {
            pedidos = new ArrayList<>();
            System.out.println("Error al recuperar pedidos: " + e.getMessage());
        }
    }

    public static boolean eliminar(int idPedido) {
        int pos = posicion(idPedido);
        if (pos != -1) {
            pedidos.remove(pos); 
            return true;
        }
        return false;
    }

    public static ArrayList<clsPedido> listar() {
        return pedidos;
    }
}
