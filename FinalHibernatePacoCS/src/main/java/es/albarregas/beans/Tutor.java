/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 *
 * @author paco
 */
@Entity
public class Tutor extends Usuario{
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Ciclo ciclo;
    
    public Tutor() {
    }

    public Tutor(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Tutor(Ciclo ciclo, String email, String password, String repitePassword, String nombre, String apellidos, Rol rol, String nif, Date UltimoAcceso) {
        super(email, password, repitePassword, nombre, apellidos, rol, nif, UltimoAcceso);
        this.ciclo = ciclo;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

}
