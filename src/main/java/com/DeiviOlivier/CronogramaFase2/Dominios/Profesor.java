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
    private Long idProfesor;
    
    @Basic
    @Column(name = "CONTRASENA_PROFESOR")
    private String contrasenaProfesor;
    @Basic
    @Column(name = "CEDULA_PROFESOR")
    private String cedulaProfesor;
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
    @OneToMany(mappedBy = "profesoresModificadores")
    private Collection<Modificador> modificadoresByIdProfesor;
    @OneToMany(mappedBy = "profesoresByIdProfesor")
    private Collection<ModuloReferencia> modulosReferenciasByIdProfesor;
    @ManyToOne
    @JoinColumn(name = "ID_ADMINISTRADOR", nullable = false)
    private Administrador administradoresByIdAdministrador;
@   OneToOne
    @JoinColumn(name="ID_ROL", referencedColumnName = "ID_ROL", nullable = false)
    private Rol rol;
    @OneToMany(mappedBy="profesorMensajes")
    private Collection<Mensaje> mensajes;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profesor that = (Profesor) o;

        if (idProfesor != that.idProfesor) return false;
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
        if (correoProfesor != null ? !correoProfesor.equals(that.correoProfesor) : that.correoProfesor != null)
            return false;
        return true;
    }


}
