package com.DeiviOlivier.CronogramaFase2.Dominios;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import lombok.Data;
@Data
@Entity
@Table(name="ADMINISTRADORES")
public class Administrador implements Serializable {
    
    private static final long serialVersionUID=1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ADMINISTRADOR")
    private Long idAdministrador;

    @Basic
    @Column(name = "CEDULA_ADMINISTRADOR")
    private int cedulaAdministrador;
    @Basic
    @Column(name = "CONTRASENA_ADMINISTRADOR")
    private String contrasenaAdministrador;
    @Transient
    private String contrasenaRepetida;
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

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "ID_CENTRO_FORMACION", nullable = false)
    private CentroFormacion centrosFormacionesByIdCentroFormacion;
    @OneToMany(mappedBy = "administradoresByIdAdministrador")
    private Collection<Profesor> profesoresByIdAdministrador;
    @OneToOne
    @JoinColumn(name="ID_ROL", referencedColumnName = "ID_ROL", nullable = false)
    private Rol rol;
    @OneToMany(mappedBy="administradorMensajes")
    private Collection<Mensaje> mensajes;
  
}
