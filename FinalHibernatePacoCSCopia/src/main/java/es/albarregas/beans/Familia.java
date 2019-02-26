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
import javax.persistence.Table;

/**
 *
 * @author paco
 */
@Entity
@Table(name = "familias")
public class Familia implements Serializable{
    
    @Id
    @Column(name = "IdFamilia")
    protected String idFamilia;
    
    @Column(name = "Denominacion")
    protected String denominacion;
    

    public String getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(String IdFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    
    
}
