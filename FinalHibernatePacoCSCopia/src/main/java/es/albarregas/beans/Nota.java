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
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author paco
 */
@Entity
public class Nota implements Serializable{
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    protected int idNotas;
    
    protected int nota;
    
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    protected Alumno alumno;
    
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    protected Modulo modulo;
    
}
