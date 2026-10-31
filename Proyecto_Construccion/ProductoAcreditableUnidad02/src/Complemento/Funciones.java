/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Complemento;

import javax.swing.JOptionPane;

public class Funciones {
    
    public static int dialogoPregunta(String cadena)
    {
        Object[] opciones = {"SI", "NO"};
        int respuesta = JOptionPane.showOptionDialog(
                    null,
                    cadena,
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones, 
                    opciones[0] 
                );
        return respuesta;
    }
    
}
