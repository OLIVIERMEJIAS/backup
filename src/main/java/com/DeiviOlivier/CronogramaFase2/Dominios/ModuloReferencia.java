package com.DeiviOlivier.CronogramaFase2.Dominios;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import lombok.Data;
@Data
@Entity
@Table(name = "MODULOS_REFERENCIAS")
public class ModuloReferencia implements Serializable {
    private static final long serialVersionUID=1L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_MODULO_REFERENCIA")
    private Long idModuloReferencia;
    @Basic
    @Column(name = "DIAS_MODULO_REFERENCIA")
    private String diasModuloReferencia;
    @Basic
    @Column(name = "HORA_INICIO_MODULO_REFERENCIA")
    private String horaInicioModuloReferencia;
    @Basic
    @Column(name = "HORA_FINAL_MODULO_REFERENCIA")
    private String horaFinalModuloReferencia;
    @Basic
    @Column(name = "INICIO_MODULO_REFERENCIA",nullable = true)
    private Date inicioModuloReferencia;
    @Basic
    @Column(name = "FINAL_MODULO_REFERENCIA",nullable = true)
    private Date finalModuloReferencia;
    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "ID_MODULO ", nullable = false)
    private Modulo modulo;
    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "ID_PROFESOR", nullable = false)
    private Profesor profesor;
    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "ID_REFERENCIA", nullable = false)
    private Referencia referencia;


}
