/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author paco
 */
@Entity
public class Nota implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int idNotas;
    
    protected int nota;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Alumno alumno;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Modulo modulo;

    public int getIdNotas() {
        return idNotas;
    }

    public void setIdNotas(int idNotas) {
        this.idNotas = idNotas;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
    
    
}
