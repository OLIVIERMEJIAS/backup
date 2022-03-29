package com.DeiviOlivier.CronogramaFase2.Dominios;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.Collection;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
@Data
@Entity
@Table(name="REFERENCIAS")
public class Referencia implements Serializable {
    private static final long serialVersionUID=1L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_REFERENCIA")
    private Long idReferencia;
    @Basic
    @Column(name = "REFERENCIA")
    @NotEmpty(message = "Es necesario un código de referencia")
    private String codigo;
    @Basic
    @Column(name = "HORAS_MAXIMAS_REFERENCIA")
    @NotNull(message = "Es necesario un número máximo de horas lectivas")
    private Double horasMaximasReferencia; 
    @Basic
    @Column(name = "DIAS_REFERENCIA")
    @NotEmpty(message = "Es necesario elegir por lo menos un día")
    private String diasReferencia;
    @Basic
    @Column(name = "HORA_INICIO_REFERENCIA")
    @NotNull(message = "Es necesaria una hora de inicio")
    private String horaInicioReferencia;
    @Basic
    @Column(name = "HORAS_DIARIAS_REFERENCIA")
    @NotNull(message = "Es necesario indicar las horas de duración diarias")
    private Double horasDiariasReferencia;
    
    @Basic
    @Column(name = "INICIO_REFERENCIA")
    @NotNull(message="Es necesaria una fecha de inicio")
    private Date inicioReferencia;
    @Basic
    @Column(name = "FINAL_REFERENCIA",nullable = true)
    private Date finalReferencia;
    @Basic
    @Column(name = "ESTADO_REFERENCIA")
    @NotEmpty(message = "Es necesario un estado")
    private String estadoReferencia;

    @OneToMany(mappedBy = "referencia")
    private Collection<ModuloReferencia> modulosReferenciasByIdReferencia;
    @ManyToOne(optional = true,cascade = {CascadeType.MERGE})
    @JoinColumn(name = "ID_MODULO",nullable = true)
    private Modulo moduloReferencia;
    @ManyToOne(optional = true,cascade = {CascadeType.MERGE})
    @JoinColumn(name = "ID_PROGRAMA",nullable=true)
    private Programa programaReferencia;

}
