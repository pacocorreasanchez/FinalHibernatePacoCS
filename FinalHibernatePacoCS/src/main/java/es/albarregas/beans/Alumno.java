/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author paco
 */
@Entity
public class Alumno extends Usuario{
    
    @Temporal(TemporalType.DATE)
    protected Date fechaNacimiento;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected Ciclo ciclo;
    
    /*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected List<Nota> notas = new ArrayList<>();
    
    public enum Genero {
        MUJER,
        HOMBRE
    };
    @Column(name = "Genero")
    @Enumerated(EnumType.STRING)*/
    @Column(name = "Genero")
    protected String genero;

    public Alumno() {
    }

    public Alumno(Date fechaNacimiento, Ciclo ciclo) {
        this.fechaNacimiento = fechaNacimiento;
        this.ciclo = ciclo;
    }

    public Alumno(Date fechaNacimiento, Ciclo ciclo, String email, String password, String repitePassword, String nombre, String apellidos, Rol rol, String nif, Date UltimoAcceso) {
        super(email, password, repitePassword, nombre, apellidos, rol, nif, UltimoAcceso);
        this.fechaNacimiento = fechaNacimiento;
        this.ciclo = ciclo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    /*public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
    */

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
