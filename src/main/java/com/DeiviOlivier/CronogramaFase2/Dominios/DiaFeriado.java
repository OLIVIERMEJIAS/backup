package com.DeiviOlivier.CronogramaFase2.Dominios;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import lombok.Data;
@Data
@Entity
@Table(name = "DIAS_FERIADOS")
public class DiaFeriado implements Serializable{
    private static final long serialVersionUID=1L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_DIA_FERIADO")
    private Long idDiaFeriado;
    @Basic
    @Column(name = "NOMBRE_DIA_FERIADO")
    private String nombreDiaFeriado;
    @Basic
    @Column(name = "FECHA_INICIO_DIA_FERIADO")
    private Date fechaInicioDiaFeriado;
    @Basic
    @Column(name = "DIAS_TOTALES_DIA_FERIADO")
    private Long diasTotalesDiaFeriado;
    @ManyToOne
    @JoinColumn(name = "ID_CENTRO_FORMACION")
    private CentroFormacion centrosFormacionesByIdCentroFormacion;

   

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiaFeriado that = (DiaFeriado) o;

        if (idDiaFeriado != that.idDiaFeriado) return false;
        if (nombreDiaFeriado != null ? !nombreDiaFeriado.equals(that.nombreDiaFeriado) : that.nombreDiaFeriado != null)
            return false;
        if (fechaInicioDiaFeriado != null ? !fechaInicioDiaFeriado.equals(that.fechaInicioDiaFeriado) : that.fechaInicioDiaFeriado != null)
            return false;
        
        return true;
    }

}
