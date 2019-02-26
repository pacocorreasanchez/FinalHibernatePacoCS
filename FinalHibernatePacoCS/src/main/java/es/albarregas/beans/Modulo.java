/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author paco
 */
@Entity
@Table(name = "modulos")
public class Modulo implements Serializable {

    @Id
    @Column(name = "IdModulo")
    protected int idModulo;

    @Column(name = "Curso")
    protected int curso;

    @Column(name = "Abreviatura")
    protected String abreviatura;

    @Column(name = "Denominacion")
    protected String denominacion;

    @Column(name = "NumeroHoras")
    protected int numeroHoras;

    @ManyToMany(mappedBy = "modulos")
    protected Set<Ciclo> ciclos = new HashSet<>();

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public Set<Ciclo> getCiclos() {
        return ciclos;
    }

    public void setCiclos(Set<Ciclo> ciclos) {
        this.ciclos = ciclos;
    }

}
