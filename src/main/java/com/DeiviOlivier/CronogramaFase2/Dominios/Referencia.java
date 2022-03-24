package com.DeiviOlivier.CronogramaFase2.Dominios;

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
public class Referencia {
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
    private BigDecimal horasMaximasReferencia; 
    @Basic
    @Column(name = "DIAS_REFERENCIA")
    @NotEmpty(message = "Es necesario elegir por lo menos un día")
    private String diasReferencia;
    @Basic
    @Column(name = "HORA_INICIO_REFERENCIA")
    @NotNull(message = "Es necesaria una hora de inicio")
    private Time horaInicioReferencia;
    @Basic
    @Column(name = "HORA_FINAL_REFERENCIA")
    @NotNull(message = "Es necesario una hora de fin")
    private Time horaFinalReferencia;
    
   
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
 
    @OneToMany(mappedBy = "referencia",orphanRemoval = true)
    private Collection<ModuloReferencia> modulosReferenciasByIdReferencia;
    @ManyToOne(optional = true,cascade = {CascadeType.MERGE})
    @JoinColumn(name = "ID_MODULO",nullable = true)
    private Modulo moduloReferencia;
    @ManyToOne(optional = true,cascade = {CascadeType.MERGE})
    @JoinColumn(name = "ID_PROGRAMA",nullable=true)
    private Programa programaReferencia;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Referencia that = (Referencia) o;

        if (idReferencia != that.idReferencia) return false;
        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (horasMaximasReferencia != null ? !horasMaximasReferencia.equals(that.horasMaximasReferencia) : that.horasMaximasReferencia != null)
            return false;
        if (horaFinalReferencia != null ? !horaFinalReferencia.equals(that.horaFinalReferencia) : that.horaFinalReferencia != null)
            return false;
        if (diasReferencia != null ? !diasReferencia.equals(that.diasReferencia) : that.diasReferencia != null)
            return false;
        if (horaInicioReferencia != null ? !horaInicioReferencia.equals(that.horaInicioReferencia) : that.horaInicioReferencia != null)
            return false;
        if (inicioReferencia != null ? !inicioReferencia.equals(that.inicioReferencia) : that.inicioReferencia != null)
            return false;
        if (finalReferencia != null ? !finalReferencia.equals(that.finalReferencia) : that.finalReferencia != null)
            return false;
        if (estadoReferencia != null ? !estadoReferencia.equals(that.estadoReferencia) : that.estadoReferencia != null)
            return false;

        return true;
    }

  

  
 
}
