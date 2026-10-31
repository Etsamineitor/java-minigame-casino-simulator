/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa_datos;

import capa_logica.clsUsuario;

/**

 */
public class clsUsuarioDAO {
    private static clsUsuario[] objetos = new clsUsuario[20];
    private static int cantidad;
    
//     public clsUsuarioDAO()
//    {
//        cantidad = 0;
//    }
    
    public static void agregar(clsUsuario clsUsu)
    {
        if(cantidad < 20)
        {
            objetos[cantidad] = clsUsu;
            cantidad++;
        }
    }
    
    public static clsUsuario[] obtener()
    {
        return objetos;
    }
    
    public static int getCantidad()
    {
        return cantidad;
    }
    
    public static clsUsuario[] usuarioextipo ( String tipo )
    {
        int cantreg = 0;
        for (int i = 0; i < cantidad; i++)
            if(objetos[i].getTipo().equalsIgnoreCase(tipo))
                cantreg = cantreg+1;
        
        clsUsuario[] datos = new clsUsuario[cantreg];
        int c = 0;
        for (int i = 0; i < cantidad; i++)
            if(objetos[i].getTipo().equalsIgnoreCase(tipo))
            {
                datos[c] = objetos[i];
                c++;
            }    
        return datos;
    }
    
    public static int posicion(String usuario) {
        int pos = -1;
        for (int i = 0; i < cantidad; i++) {
            if (objetos[i].getUsuario().equals(usuario)) {
                pos = i;
                break;
            }
        }
        return pos;
    }
    
    public static clsUsuario getElemento(String usuario) {
        int pos = posicion(usuario);
        if (pos != -1) {
            return objetos[pos];
        } else {
            return null;
        }
    }
    
    public static void darBaja(int pos) {
        objetos[pos].setEstado(false);
    }
    
    public static void eliminar(int pos) {
        for (int i = pos; i < cantidad - 1; i++) {
            objetos[i] = objetos[i + 1];
        }
        cantidad--;
    }
    
    public static void modificar(int pos, clsUsuario objUsuario) {
        objetos[pos] = objUsuario;
    }

}
