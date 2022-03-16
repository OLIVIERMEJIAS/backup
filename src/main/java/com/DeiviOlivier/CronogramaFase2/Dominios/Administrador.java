package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Administrador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ADMINISTRADOR")
    private int idAdministrador;
    @Basic
    @Column(name = "ID_CENTRO_FORMACION")
    private short idCentroFormacion;
    @Basic
    @Column(name = "CEDULA_ADMINISTRADOR")
    private int cedulaAdministrador;
    @Basic
    @Column(name = "CONTRASENA_ADMINISTRADOR")
    private String contrasenaAdministrador;
    @Basic
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;
    @Basic
    @Column(name = "NOMBRE_ADMINISTRADOR")
    private String nombreAdministrador;
    @Basic
    @Column(name = "APELLIDO1_ADMINISTRADOR")
    private String apellido1Administrador;
    @Basic
    @Column(name = "APELLIDO2_ADMINISTRADOR")
    private String apellido2Administrador;
    @Basic
    @Column(name = "CORREO_ADMINISTRADOR")
    private String correoAdministrador;
    @ManyToOne
    @JoinColumn(name = "ID_CENTRO_FORMACION", referencedColumnName = "ID_CENTRO_FORMACION", nullable = false)
    private CentroFormacion centrosFormacionesByIdCentroFormacion;
    @OneToMany(mappedBy = "administradoresByIdAdministrador")
    private Collection<Profesor> profesoresByIdAdministrador;

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public short getIdCentroFormacion() {
        return idCentroFormacion;
    }

    public void setIdCentroFormacion(short idCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
    }

    public int getCedulaAdministrador() {
        return cedulaAdministrador;
    }

    public void setCedulaAdministrador(int cedulaAdministrador) {
        this.cedulaAdministrador = cedulaAdministrador;
    }

    public String getContrasenaAdministrador() {
        return contrasenaAdministrador;
    }

    public void setContrasenaAdministrador(String contrasenaAdministrador) {
        this.contrasenaAdministrador = contrasenaAdministrador;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }

    public String getApellido1Administrador() {
        return apellido1Administrador;
    }

    public void setApellido1Administrador(String apellido1Administrador) {
        this.apellido1Administrador = apellido1Administrador;
    }

    public String getApellido2Administrador() {
        return apellido2Administrador;
    }

    public void setApellido2Administrador(String apellido2Administrador) {
        this.apellido2Administrador = apellido2Administrador;
    }

    public String getCorreoAdministrador() {
        return correoAdministrador;
    }

    public void setCorreoAdministrador(String correoAdministrador) {
        this.correoAdministrador = correoAdministrador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Administrador that = (Administrador) o;

        if (idAdministrador != that.idAdministrador) return false;
        if (idCentroFormacion != that.idCentroFormacion) return false;
        if (cedulaAdministrador != that.cedulaAdministrador) return false;
        if (contrasenaAdministrador != null ? !contrasenaAdministrador.equals(that.contrasenaAdministrador) : that.contrasenaAdministrador != null)
            return false;
        if (nombreUsuario != null ? !nombreUsuario.equals(that.nombreUsuario) : that.nombreUsuario != null)
            return false;
        if (nombreAdministrador != null ? !nombreAdministrador.equals(that.nombreAdministrador) : that.nombreAdministrador != null)
            return false;
        if (apellido1Administrador != null ? !apellido1Administrador.equals(that.apellido1Administrador) : that.apellido1Administrador != null)
            return false;
        if (apellido2Administrador != null ? !apellido2Administrador.equals(that.apellido2Administrador) : that.apellido2Administrador != null)
            return false;
        if (correoAdministrador != null ? !correoAdministrador.equals(that.correoAdministrador) : that.correoAdministrador != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAdministrador;
        result = 31 * result + (int) idCentroFormacion;
        result = 31 * result + cedulaAdministrador;
        result = 31 * result + (contrasenaAdministrador != null ? contrasenaAdministrador.hashCode() : 0);
        result = 31 * result + (nombreUsuario != null ? nombreUsuario.hashCode() : 0);
        result = 31 * result + (nombreAdministrador != null ? nombreAdministrador.hashCode() : 0);
        result = 31 * result + (apellido1Administrador != null ? apellido1Administrador.hashCode() : 0);
        result = 31 * result + (apellido2Administrador != null ? apellido2Administrador.hashCode() : 0);
        result = 31 * result + (correoAdministrador != null ? correoAdministrador.hashCode() : 0);
        return result;
    }

    public CentroFormacion getCentrosFormacionesByIdCentroFormacion() {
        return centrosFormacionesByIdCentroFormacion;
    }

    public void setCentrosFormacionesByIdCentroFormacion(CentroFormacion centrosFormacionesByIdCentroFormacion) {
        this.centrosFormacionesByIdCentroFormacion = centrosFormacionesByIdCentroFormacion;
    }

    public Collection<Profesor> getProfesoresByIdAdministrador() {
        return profesoresByIdAdministrador;
    }

    public void setProfesoresByIdAdministrador(Collection<Profesor> profesoresByIdAdministrador) {
        this.profesoresByIdAdministrador = profesoresByIdAdministrador;
    }
}
