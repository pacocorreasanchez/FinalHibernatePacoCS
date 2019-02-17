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
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    protected Ciclo ciclo;

    public Tutor(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Tutor(Ciclo ciclo, int idUsuario, String email, String password, String nombre, String apellidos, String dni, Date ultimoAcceso, String avatar) {
        super(idUsuario, email, password, nombre, apellidos, dni, ultimoAcceso, avatar);
        this.ciclo = ciclo;
    }

    public Tutor() {
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }
    
}
