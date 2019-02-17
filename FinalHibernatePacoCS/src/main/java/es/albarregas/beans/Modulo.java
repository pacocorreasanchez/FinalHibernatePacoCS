/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author paco
 */
@Entity
public class Modulo implements Serializable{
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
    protected Ciclo ciclo;

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }
}
