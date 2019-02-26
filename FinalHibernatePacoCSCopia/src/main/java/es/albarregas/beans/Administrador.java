/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author paco
 */
@Entity
public class Administrador extends Usuario{
    protected boolean modoDios;

    public Administrador(boolean modoDios) {
        this.modoDios = modoDios;
    }

    public Administrador(boolean modoDios, int idUsuario, String email, String password, String nombre, String apellidos, String dni, Date ultimoAcceso, String avatar) {
        super(idUsuario, email, password, nombre, apellidos, dni, ultimoAcceso, avatar);
        this.modoDios = modoDios;
    }

    public Administrador() {
    }

    public boolean isModoDios() {
        return modoDios;
    }

    public void setModoDios(boolean modoDios) {
        this.modoDios = modoDios;
    }
    
}
