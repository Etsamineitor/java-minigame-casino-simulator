/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa_logica;

import capa_datos.clsUsuarioDAO;

/**

 */
public class clsUsuario {

    private String usuario;
    private String clave;
    private String tipo;
    private boolean estado;

    public clsUsuario() {
        this.usuario = "";
        this.clave = "";
        this.tipo = "";
        this.estado = false;
    }

    public clsUsuario(String usuario, String clave, String nombre, String tipo, boolean estado) {
        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return usuario + "\t" + clave + "\t" + tipo + "\t" + estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean IniciarSesion() {
        // Primero verificar admin
        if (usuario.equalsIgnoreCase("Admin") && clave.equals("5225")) {
            this.tipo = "Admin";
            this.estado = true;
            return true;
        }

        for (int i = 0; i < clsUsuarioDAO.getCantidad(); i++) {
            clsUsuario u = clsUsuarioDAO.obtener()[i];
            if (u != null && u.getUsuario().equalsIgnoreCase(this.usuario)
                    && u.getClave().equals(this.clave)
                    && u.isEstado()) {
                this.tipo = u.getTipo();
                this.estado = true;
                return true;
            }
        }

        return false; 
    }


    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
