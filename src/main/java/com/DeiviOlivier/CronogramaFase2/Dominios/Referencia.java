package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.Collection;
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
    private String referencia;
    @Basic
    @Column(name = "HORAS_MAXIMAS_REFERENCIA")
    private BigDecimal horasMaximasReferencia; 
    @Basic
    @Column(name = "DIAS_REFERENCIA")
    private String diasReferencia;
    @Basic
    @Column(name = "HORA_INICIO_REFERENCIA")
    private String horaInicioReferencia;
    @Basic
    @Column(name = "HORA_FINAL_REFERENCIA")
    private String horaFinalReferencia;
    
   
    @Basic
    @Column(name = "INICIO_REFERENCIA")
    private Date inicioReferencia;
    @Basic
    @Column(name = "FINAL_REFERENCIA")
    private Date finalReferencia;
    @Basic
    @Column(name = "ESTADO_REFERENCIA")
    private String estadoReferencia;
    @OneToMany(mappedBy = "referencia")
    private Collection<ModuloReferencia> modulosReferenciasByIdReferencia;
    @ManyToOne
    @JoinColumn(name = "ID_MODULO")
    private Modulo moduloReferencia;
    @ManyToOne
    @JoinColumn(name = "ID_PROGRAMA")
    private Programa programaReferencia;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Referencia that = (Referencia) o;

        if (idReferencia != that.idReferencia) return false;
        if (referencia != null ? !referencia.equals(that.referencia) : that.referencia != null) return false;
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
