package com.DeiviOlivier.CronogramaFase2.Dominios;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import lombok.Data;

@Data
@Entity
@Table(name="PROFESORES")
public class Profesor implements Serializable{
    private static final long serialVersionUID=1L;
    
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
    @OneToMany(mappedBy = "profesor")
    private Collection<ModuloReferencia> modulosReferenciasByIdProfesor;
    @ManyToOne
    @JoinColumn(name = "ID_ADMINISTRADOR", nullable = false)
    private Administrador administradoresByIdAdministrador;
@   OneToOne
    @JoinColumn(name="ID_ROL", referencedColumnName = "ID_ROL", nullable = false)
    private Rol rol;
    @OneToMany(mappedBy="profesorMensajes")
    private Collection<Mensaje> mensajes;
}
