package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.sql.Date;
import lombok.Data;
@Data
@Entity
@Table(name = "DIAS_FERIADOS")
public class DiaFeriado {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_DIA_FERIADO")
    private byte idDiaFeriado;
    @Basic
    @Column(name = "NOMBRE_DIA_FERIADO")
    private String nombreDiaFeriado;
    @Basic
    @Column(name = "FECHA_INICIO_DIA_FERIADO")
    private Date fechaInicioDiaFeriado;
    @Basic
    @Column(name = "ID_CENTRO_FORMACION")
    private Short idCentroFormacion;
    @ManyToOne
    @JoinColumn(name = "ID_CENTRO_FORMACION", referencedColumnName = "ID_CENTRO_FORMACION")
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
        if (idCentroFormacion != null ? !idCentroFormacion.equals(that.idCentroFormacion) : that.idCentroFormacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idDiaFeriado;
        result = 31 * result + (nombreDiaFeriado != null ? nombreDiaFeriado.hashCode() : 0);
        result = 31 * result + (fechaInicioDiaFeriado != null ? fechaInicioDiaFeriado.hashCode() : 0);
        result = 31 * result + (idCentroFormacion != null ? idCentroFormacion.hashCode() : 0);
        return result;
    }

   
}
