package com.DeiviOlivier.CronogramaFase2.Dominios;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
@Data
@Entity
@Table(name="MODULOS")
public class Modulo implements Serializable {
    private static final long serialVersionUID=1L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_MODULO")
    private Long idModulo;
    
    @Column(name = "NOMBRE_MODULO")
    @NotEmpty(message="El Nombre es obligatorio")
    private String nombreModulo;
    
    @Column(name = "CODIGO_MODULO")
    @NotEmpty(message="El Nombre es obligatorio")
    private String codigoModulo;
    @Basic
    @Column(name = "HORAS_MODULO")
    private short horasModulo;
    @Basic
    @Column(name = "REQUISITO_MODULO")
    private String requisitoModulo;

    @OneToMany(mappedBy = "programasByIdPrograma")
    private Collection<ModulosProgramas> modulosProgramas;
     @OneToMany(mappedBy = "modulosByIdModulo")
    private Collection<ModulosProgramas> modulosPrograma;
    @OneToMany(mappedBy = "modulo")
    private Collection<ModuloReferencia> modulosReferenciasByIdModulo;
    @OneToMany(mappedBy = "moduloReferencia")
    private Collection<Referencia> referencia;

}
