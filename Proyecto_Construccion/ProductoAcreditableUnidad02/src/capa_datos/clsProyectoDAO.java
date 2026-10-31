/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa_datos;

import capa_logica.clsProyecto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**

 */
public class clsProyectoDAO {

    private static ArrayList<clsProyecto> proyectos = new ArrayList<>();

    private static final String CARPETA = "src/Construccion";
    private static final String ARCHIVO = CARPETA + File.separator + "proyectos.dat";

    public static boolean agregar(clsProyecto p) {
        if (posicion(p.getIdProyecto()) != -1) {
            return false;
        }
        proyectos.add(p);
        return true;
    }

    public static ArrayList<clsProyecto> obtener() {
        return proyectos;
    }

    public static int posicion(int idProyecto) {
        for (int i = 0; i < proyectos.size(); i++) {
            if (proyectos.get(i).getIdProyecto() == idProyecto) {
                return i;
            }
        }
        return -1;
    }

    public static clsProyecto buscar(int idProyecto) {
        int pos = posicion(idProyecto);
        return (pos == -1) ? null : proyectos.get(pos);
    }

    public static void modificar(int pos, clsProyecto nuevo) {
        proyectos.set(pos, nuevo);
    }

    public static void eliminar(int pos) {
        proyectos.remove(pos);
    }

    public static void darBaja(int pos) {
        proyectos.get(pos).setEstado(false);
    }

    public static ArrayList<clsProyecto> listarVigentes() {
        ArrayList<clsProyecto> lista = new ArrayList<>();
        for (clsProyecto p : proyectos) {
            if (p.isEstado()) {
                lista.add(p);
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
            oos.writeObject(proyectos);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error al grabar proyectos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static void recuperar() {
        try {
            File f = new File(ARCHIVO);
            if (f.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                ArrayList<clsProyecto> temp
                        = (ArrayList<clsProyecto>) ois.readObject();
                ois.close();

                proyectos.clear();
                proyectos.addAll(temp);
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar proyectos: " + e.getMessage());
        }
    }

    public static int generarCodigo() {
        int max = 0;
        for (clsProyecto p : proyectos) {
            if (p.getIdProyecto() > max) {
                max = p.getIdProyecto();
            }
        }
        return max + 1;
    }

    public static boolean existeNombre(String nombre) {
        if (nombre == null) {
            return false;
        }

        String nom = nombre.trim().toUpperCase();
        for (clsProyecto p : proyectos) {
            if (p != null && p.getNombre() != null) {
                if (p.getNombre().trim().toUpperCase().equals(nom)) {
                    return true;
                }
            }
        }
        return false;
    }

}
