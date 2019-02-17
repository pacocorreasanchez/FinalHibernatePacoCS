/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author paco
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    protected int idUsuario;
    
    @NotNull(message="No puede estar vacío")
    @Column(unique=true)
    @Pattern(regexp=".+@.+\\..+", message="Email invalido")
    protected String email;
    
    @NotNull(message="No puede estar vacío")
    protected String password;
    
    protected String nombre;
    protected String apellidos;
    protected enum Rol {
        ADMIN,
        TUTOR,
        ALUMNO
    };
    
    @Column(unique=true)
    protected String dni;
    
    @Temporal(TemporalType.DATE)
    protected Date ultimoAcceso;
    
    protected String avatar;

    public Usuario() {
    }

    public Usuario(int idUsuario, String email, String password, String nombre, String apellidos, String dni, Date ultimoAcceso, String avatar) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.ultimoAcceso = ultimoAcceso;
        this.avatar = avatar;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    
    
}
