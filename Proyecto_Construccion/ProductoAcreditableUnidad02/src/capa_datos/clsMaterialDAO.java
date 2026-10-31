/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa_datos;

import capa_logica.clsMaterial;
import java.io.*;
import java.util.ArrayList;

/**

 */
public class clsMaterialDAO {

    private static ArrayList<clsMaterial> materiales = new ArrayList<>();

    private static final String CARPETA = "src/Construccion";
    private static final String ARCHIVO = CARPETA + File.separator + "materiales.dat";

    public static boolean agregar(clsMaterial m) {
        if (posicion(m.getCodigo()) != -1) {
            return false;
        }
        materiales.add(m);
        return true;
    }

    public static ArrayList<clsMaterial> obtener() {
        return materiales;
    }

    public static int posicion(int codigo) {
        for (int i = 0; i < materiales.size(); i++) {
            if (materiales.get(i).getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    public static clsMaterial buscar(int codigo) {
        int pos = posicion(codigo);
        return (pos == -1) ? null : materiales.get(pos);
    }

    public static void modificar(int pos, clsMaterial nuevo) {
        materiales.set(pos, nuevo);
    }

    public static void eliminar(int pos) {
        materiales.remove(pos);
    }

    public static void darBaja(int pos) {
        materiales.get(pos).setActivo(false);
    }

    public static ArrayList<clsMaterial> listarActivos() {
        ArrayList<clsMaterial> lista = new ArrayList<>();
        for (clsMaterial m : materiales) {
            if (m.isActivo()) {
                lista.add(m);
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
            oos.writeObject(materiales);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error al grabar materiales: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static void recuperar() {
        try {
            File f = new File(ARCHIVO);
            if (f.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                materiales = (ArrayList<clsMaterial>) ois.readObject();
                ois.close();
            } else {
                materiales = new ArrayList<>();
            }
        } catch (Exception e) {
            materiales = new ArrayList<>();
            System.out.println("Error al recuperar materiales: " + e.getMessage());
        }
    }

    public static int generarCodigo() {
        int max = 0;
        for (clsMaterial m : materiales) {
            if (m.getCodigo() > max) {
                max = m.getCodigo();
            }
        }
        return max + 1;
    }

    public static boolean existeNombre(String nombre) {
        if (nombre == null) {
            return false;
        }
        String nom = nombre.trim().toUpperCase();

        for (clsMaterial m : materiales) {
            if (m != null && m.getNombre() != null) {
                if (m.getNombre().trim().toUpperCase().equals(nom)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static clsMaterial buscarPorNombre(String nombre) {
        if (nombre == null) {
            return null;
        }
        String nom = nombre.trim().toUpperCase();
        for (clsMaterial m : materiales) {
            if (m.getNombre().trim().toUpperCase().equals(nom)) {
                return m;
            }
        }
        return null;
    }
}
