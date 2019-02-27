package es.albarregas.beans;

import es.albarregas.exceptions.BussinessException.Caption;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 *
 * @author paco
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdUsuario")
    int idUsuario;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "Email",unique = true)
    private String email;

    @NotBlank
    @Column(name = "Password")
    @Caption("contraseña")
    private String password;
    @NotBlank
    @Transient
    private String repitePassword;

    @NotNull
    @Column(name = "Nombre")
    @Size(min = 2, max = 20)
    private String nombre;

    @Size(max = 60)
    @Column(name = "Apellidos")
    private String apellidos;

    public enum Rol {
        ADMINISTRADOR,
        TUTOR,
        ALUMNO
    };
    @Column(name = "Rol")
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @Pattern(regexp = "[0-9]{8}[A-Z]{1}", message = "El nif debe contener 8 dígitos y una letra mayúscula")
    @Size(max = 9)
    @Column(name = "NIF")
    private String nif;

    @Column(name = "UltimoAcceso")
    @Temporal(TemporalType.DATE)
    private Date UltimoAcceso;

    public Usuario() {
    }

    public Usuario(String email, String password, String repitePassword, String nombre, String apellidos, Rol rol, String nif, Date UltimoAcceso) {
        this.email = email;
        this.password = password;
        this.repitePassword = repitePassword;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.rol = rol;
        this.nif = nif;
        this.UltimoAcceso = UltimoAcceso;
    }

    

    @AssertTrue(message = "Las contraseñas deben coincidir")
    private boolean isPasswords() {
        return this.password.equals(this.repitePassword);
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Date getUltimoAcceso() {
        return UltimoAcceso;
    }

    public void setUltimoAcceso(Date UltimoAcceso) {
        this.UltimoAcceso = UltimoAcceso;
    }

    public String getRepitePassword() {
        return repitePassword;
    }

    public void setRepitePassword(String repitePassword) {
        this.repitePassword = repitePassword;
    }

    
}
