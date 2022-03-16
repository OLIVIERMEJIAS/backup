package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Referencia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_REFERENCIA")
    private int idReferencia;
    @Basic
    @Column(name = "ID_ELEMENTO")
    private Short idElemento;
    @Basic
    @Column(name = "REFERENCIA")
    private String referencia;
    @Basic
    @Column(name = "HORAS_MAXIMAS_REFERENCIA")
    private BigDecimal horasMaximasReferencia;
    @Basic
    @Column(name = "HORAS_DIARIAS_REFERENCIA")
    private BigDecimal horasDiariasReferencia;
    @Basic
    @Column(name = "DIAS_REFERENCIA")
    private String diasReferencia;
    @Basic
    @Column(name = "HORA_INICIO_REFERENCIA")
    private Object horaInicioReferencia;
    @Basic
    @Column(name = "INICIO_REFERENCIA")
    private Date inicioReferencia;
    @Basic
    @Column(name = "FINAL_REFERENCIA")
    private Date finalReferencia;
    @Basic
    @Column(name = "ESTADO_REFERENCIA")
    private String estadoReferencia;
    @OneToMany(mappedBy = "referenciasByIdReferencia")
    private Collection<ModuloReferencia> modulosReferenciasByIdReferencia;
    @ManyToOne
    @JoinColumn(name = "ID_ELEMENTO", referencedColumnName = "ID_PROGRAMA")
    private Programa programasByIdElemento;

    public int getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(int idReferencia) {
        this.idReferencia = idReferencia;
    }

    public Short getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Short idElemento) {
        this.idElemento = idElemento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public BigDecimal getHorasMaximasReferencia() {
        return horasMaximasReferencia;
    }

    public void setHorasMaximasReferencia(BigDecimal horasMaximasReferencia) {
        this.horasMaximasReferencia = horasMaximasReferencia;
    }

    public BigDecimal getHorasDiariasReferencia() {
        return horasDiariasReferencia;
    }

    public void setHorasDiariasReferencia(BigDecimal horasDiariasReferencia) {
        this.horasDiariasReferencia = horasDiariasReferencia;
    }

    public String getDiasReferencia() {
        return diasReferencia;
    }

    public void setDiasReferencia(String diasReferencia) {
        this.diasReferencia = diasReferencia;
    }

    public Object getHoraInicioReferencia() {
        return horaInicioReferencia;
    }

    public void setHoraInicioReferencia(Object horaInicioReferencia) {
        this.horaInicioReferencia = horaInicioReferencia;
    }

    public Date getInicioReferencia() {
        return inicioReferencia;
    }

    public void setInicioReferencia(Date inicioReferencia) {
        this.inicioReferencia = inicioReferencia;
    }

    public Date getFinalReferencia() {
        return finalReferencia;
    }

    public void setFinalReferencia(Date finalReferencia) {
        this.finalReferencia = finalReferencia;
    }

    public String getEstadoReferencia() {
        return estadoReferencia;
    }

    public void setEstadoReferencia(String estadoReferencia) {
        this.estadoReferencia = estadoReferencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Referencia that = (Referencia) o;

        if (idReferencia != that.idReferencia) return false;
        if (idElemento != null ? !idElemento.equals(that.idElemento) : that.idElemento != null) return false;
        if (referencia != null ? !referencia.equals(that.referencia) : that.referencia != null) return false;
        if (horasMaximasReferencia != null ? !horasMaximasReferencia.equals(that.horasMaximasReferencia) : that.horasMaximasReferencia != null)
            return false;
        if (horasDiariasReferencia != null ? !horasDiariasReferencia.equals(that.horasDiariasReferencia) : that.horasDiariasReferencia != null)
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

    @Override
    public int hashCode() {
        int result = idReferencia;
        result = 31 * result + (idElemento != null ? idElemento.hashCode() : 0);
        result = 31 * result + (referencia != null ? referencia.hashCode() : 0);
        result = 31 * result + (horasMaximasReferencia != null ? horasMaximasReferencia.hashCode() : 0);
        result = 31 * result + (horasDiariasReferencia != null ? horasDiariasReferencia.hashCode() : 0);
        result = 31 * result + (diasReferencia != null ? diasReferencia.hashCode() : 0);
        result = 31 * result + (horaInicioReferencia != null ? horaInicioReferencia.hashCode() : 0);
        result = 31 * result + (inicioReferencia != null ? inicioReferencia.hashCode() : 0);
        result = 31 * result + (finalReferencia != null ? finalReferencia.hashCode() : 0);
        result = 31 * result + (estadoReferencia != null ? estadoReferencia.hashCode() : 0);
        return result;
    }

    public Collection<ModuloReferencia> getModulosReferenciasByIdReferencia() {
        return modulosReferenciasByIdReferencia;
    }

    public void setModulosReferenciasByIdReferencia(Collection<ModuloReferencia> modulosReferenciasByIdReferencia) {
        this.modulosReferenciasByIdReferencia = modulosReferenciasByIdReferencia;
    }

    public Programa getProgramasByIdElemento() {
        return programasByIdElemento;
    }

    public void setProgramasByIdElemento(Programa programasByIdElemento) {
        this.programasByIdElemento = programasByIdElemento;
    }
}
