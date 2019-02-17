/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author paco
 */
@Entity
@Table(name = "ciclos")
public class Ciclo implements Serializable{
    
    @Id
    @Column(name = "IdCiclo")
    protected String idCiclo;
    
    @Column(name = "Abreviatura")
    protected String abreviatura;
    
    @Column(name = "HorasFCT")
    protected int horasFCT;
    
    @Column(name = "Ley")
    protected String ley;
    
    @Column(name = "Nombre")
    protected String nombre;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ciclosmodulos",
            joinColumns = @JoinColumn(name = "IdCiclo"),
            inverseJoinColumns = @JoinColumn(name = "IdModulo"))
    protected List<Modulo> modulos = new ArrayList<>();

    public String getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(String idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public int getHorasFCT() {
        return horasFCT;
    }

    public void setHorasFCT(int horasFCT) {
        this.horasFCT = horasFCT;
    }

    public String getLey() {
        return ley;
    }

    public void setLey(String ley) {
        this.ley = ley;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }
    
}
