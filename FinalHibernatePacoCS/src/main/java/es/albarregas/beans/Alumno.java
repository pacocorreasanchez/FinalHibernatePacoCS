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
import javax.persistence.Entity;
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
    protected enum genero {
        MUJER,
        HOMBRE
    };
    
    @Temporal(TemporalType.DATE)
    protected Date fechaNacimiento;
    
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    protected Ciclo ciclo;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected List<Nota> notas = new ArrayList<>();

    public Alumno() {
    }

    public Alumno(Date fechaNacimiento, Ciclo ciclo) {
        this.fechaNacimiento = fechaNacimiento;
        this.ciclo = ciclo;
    }

    public Alumno(Date fechaNacimiento, Ciclo ciclo, int idUsuario, String email, String password, String nombre, String apellidos, String dni, Date ultimoAcceso, String avatar) {
        super(idUsuario, email, password, nombre, apellidos, dni, ultimoAcceso, avatar);
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

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
    
    
}
