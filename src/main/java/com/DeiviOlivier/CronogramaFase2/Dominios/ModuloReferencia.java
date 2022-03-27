package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.sql.Date;
import lombok.Data;
@Data
@Entity
@Table(name = "MODULOS_REFERENCIAS")
public class ModuloReferencia {
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
    @ManyToOne
    @JoinColumn(name = "ID_MODULO ", nullable = false)
    private Modulo modulo;
    @ManyToOne
    @JoinColumn(name = "ID_PROFESOR", nullable = false)
    private Profesor profesor;
    @ManyToOne
    @JoinColumn(name = "ID_REFERENCIA", nullable = false)
    private Referencia referencia;

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModuloReferencia that = (ModuloReferencia) o;

        if (idModuloReferencia != that.idModuloReferencia) return false;
        if (diasModuloReferencia != null ? !diasModuloReferencia.equals(that.diasModuloReferencia) : that.diasModuloReferencia != null)
            return false;
        if (horaInicioModuloReferencia != null ? !horaInicioModuloReferencia.equals(that.horaInicioModuloReferencia) : that.horaInicioModuloReferencia != null)
            return false;
        if (horaFinalModuloReferencia != null ? !horaFinalModuloReferencia.equals(that.horaFinalModuloReferencia) : that.horaFinalModuloReferencia != null)
            return false;
        if (inicioModuloReferencia != null ? !inicioModuloReferencia.equals(that.inicioModuloReferencia) : that.inicioModuloReferencia != null)
            return false;
        if (finalModuloReferencia != null ? !finalModuloReferencia.equals(that.finalModuloReferencia) : that.finalModuloReferencia != null)
            return false;

        return true;
    }




}
