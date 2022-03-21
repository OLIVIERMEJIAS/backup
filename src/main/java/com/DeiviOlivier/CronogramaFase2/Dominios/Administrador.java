package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.util.Collection;
import lombok.Data;
@Data
@Entity
@Table(name="ADMINISTRADORES")
public class Administrador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ADMINISTRADOR")
    private int idAdministrador;

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
    @JoinColumn(name = "ID_CENTRO_FORMACION", nullable = false)
    private CentroFormacion centrosFormacionesByIdCentroFormacion;
    @OneToMany(mappedBy = "administradoresByIdAdministrador")
    private Collection<Profesor> profesoresByIdAdministrador;
    @OneToOne
    @JoinColumn(name="ID_ROL", referencedColumnName = "ID_ROL", nullable = false)
    private Rol rol;
    @OneToMany(mappedBy="administradorMensajes")
    private Collection<Mensaje> mensajes;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Administrador that = (Administrador) o;

        if (idAdministrador != that.idAdministrador) return false;
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
        result = 31 * result + cedulaAdministrador;
        result = 31 * result + (contrasenaAdministrador != null ? contrasenaAdministrador.hashCode() : 0);
        result = 31 * result + (nombreUsuario != null ? nombreUsuario.hashCode() : 0);
        result = 31 * result + (nombreAdministrador != null ? nombreAdministrador.hashCode() : 0);
        result = 31 * result + (apellido1Administrador != null ? apellido1Administrador.hashCode() : 0);
        result = 31 * result + (apellido2Administrador != null ? apellido2Administrador.hashCode() : 0);
        result = 31 * result + (correoAdministrador != null ? correoAdministrador.hashCode() : 0);
        return result;
    }

    
}
