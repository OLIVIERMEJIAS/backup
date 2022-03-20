package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.util.Collection;
import lombok.Data;

@Data
@Entity
@Table(name="PROFESORES")
public class Profesor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PROFESOR")
    private int idProfesor;
    @Basic
    @Column(name = "ID_ADMINISTRADOR")
    private int idAdministrador;
    @Basic
    @Column(name = "CONTRASENA_PROFESOR")
    private String contrasenaProfesor;
    @Basic
    @Column(name = "CEDULA_PROFESOR")
    private int cedulaProfesor;
    @Basic
    @Column(name = "NOMBRE_PROFESOR")
    private String nombreProfesor;
    @Basic
    @Column(name = "APELLIDO1_PROFESOR")
    private String apellido1Profesor;
    @Basic
    @Column(name = "APELLIDO2_PROFESOR")
    private String apellido2Profesor;
    @Basic
    @Column(name = "CORREO_PROFESOR")
    private String correoProfesor;
    @Column(name="ID_ROL")
    private byte idRol;
    @OneToMany(mappedBy = "profesoresByIdProfesor")
    private Collection<Modificador> modificadoresByIdProfesor;
    @OneToMany(mappedBy = "profesoresByIdProfesor")
    private Collection<ModuloReferencia> modulosReferenciasByIdProfesor;
    @ManyToOne
    @JoinColumn(name = "ID_ADMINISTRADOR", referencedColumnName = "ID_ADMINISTRADOR", nullable = false)
    private Administrador administradoresByIdAdministrador;
@   OneToOne
    @JoinColumn(name="ID_ROL", referencedColumnName = "ID_ROL", nullable = false)
    private Rol rol;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profesor that = (Profesor) o;

        if (idProfesor != that.idProfesor) return false;
        if (idAdministrador != that.idAdministrador) return false;
        if (cedulaProfesor != that.cedulaProfesor) return false;
        if (contrasenaProfesor != null ? !contrasenaProfesor.equals(that.contrasenaProfesor) : that.contrasenaProfesor != null)
            return false;
        if (nombreProfesor != null ? !nombreProfesor.equals(that.nombreProfesor) : that.nombreProfesor != null)
            return false;
        if (apellido1Profesor != null ? !apellido1Profesor.equals(that.apellido1Profesor) : that.apellido1Profesor != null)
            return false;
        if (apellido2Profesor != null ? !apellido2Profesor.equals(that.apellido2Profesor) : that.apellido2Profesor != null)
            return false;
        if (correoProfesor != null ? !correoProfesor.equals(that.correoProfesor) : that.correoProfesor != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProfesor;
        result = 31 * result + idAdministrador;
        result = 31 * result + (contrasenaProfesor != null ? contrasenaProfesor.hashCode() : 0);
        result = 31 * result + cedulaProfesor;
        result = 31 * result + (nombreProfesor != null ? nombreProfesor.hashCode() : 0);
        result = 31 * result + (apellido1Profesor != null ? apellido1Profesor.hashCode() : 0);
        result = 31 * result + (apellido2Profesor != null ? apellido2Profesor.hashCode() : 0);
        result = 31 * result + (correoProfesor != null ? correoProfesor.hashCode() : 0);
        return result;
    }


}
