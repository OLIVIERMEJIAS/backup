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
    private int idModuloReferencia;
    @Basic
    @Column(name = "ID_MODULO ")
    private short idModulo;
    @Basic
    @Column(name = "ID_PROFESOR")
    private int idProfesor;
    @Basic
    @Column(name = "ID_REFERENCIA")
    private int idReferencia;
    @Basic
    @Column(name = "DIAS_MODULO_REFERENCIA")
    private String diasModuloReferencia;
    @Basic
    @Column(name = "HORA_INICIO_MODULO REFERENCIA")
    private String horaInicioModuloReferencia;
    @Basic
    @Column(name = "HORA_FINAL_MODULO REFERENCIA")
    private String horaFinalModuloReferencia;
    @Basic
    @Column(name = "INICIO_MODULO_REFERENCIA")
    private Date inicioModuloReferencia;
    @Basic
    @Column(name = "FINAL_MODULO_REFERENCIA")
    private Date finalModuloReferencia;
    @ManyToOne
    @JoinColumn(name = "ID_MODULO ", referencedColumnName = "ID_MODULO", nullable = false)
    private Modulo modulosByIdModulo;
    @ManyToOne
    @JoinColumn(name = "ID_PROFESOR", referencedColumnName = "ID_PROFESOR", nullable = false)
    private Profesor profesoresByIdProfesor;
    @ManyToOne
    @JoinColumn(name = "ID_REFERENCIA", referencedColumnName = "ID_REFERENCIA", nullable = false)
    private Referencia referenciasByIdReferencia;

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModuloReferencia that = (ModuloReferencia) o;

        if (idModuloReferencia != that.idModuloReferencia) return false;
        if (idModulo != that.idModulo) return false;
        if (idProfesor != that.idProfesor) return false;
        if (idReferencia != that.idReferencia) return false;
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

    @Override
    public int hashCode() {
        int result = idModuloReferencia;
        result = 31 * result + (int) idModulo;
        result = 31 * result + idProfesor;
        result = 31 * result + idReferencia;
        result = 31 * result + (diasModuloReferencia != null ? diasModuloReferencia.hashCode() : 0);
        result = 31 * result + (horaInicioModuloReferencia != null ? horaInicioModuloReferencia.hashCode() : 0);
        result = 31 * result + (horaFinalModuloReferencia != null ? horaFinalModuloReferencia.hashCode() : 0);
        result = 31 * result + (inicioModuloReferencia != null ? inicioModuloReferencia.hashCode() : 0);
        result = 31 * result + (finalModuloReferencia != null ? finalModuloReferencia.hashCode() : 0);
        return result;
    }


}
