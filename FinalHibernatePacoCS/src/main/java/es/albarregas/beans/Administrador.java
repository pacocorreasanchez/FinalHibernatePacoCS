/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author paco
 */
@Entity
public class Administrador extends Usuario{
    @Column(name = "ModoDios")
    private boolean modoDios;

    public Administrador() {
    }
    
    public Administrador(boolean modoDios) {
        this.modoDios = modoDios;
    }

    public Administrador(boolean modoDios, String email, String password, String repitePassword, String nombre, String apellidos, Rol rol, String nif, Date UltimoAcceso) {
        super(email, password, repitePassword, nombre, apellidos, rol, nif, UltimoAcceso);
        this.modoDios = modoDios;
    }

    public boolean isModoDios() {
        return modoDios;
    }

    public void setModoDios(boolean modoDios) {
        this.modoDios = modoDios;
    }
    
    
}
