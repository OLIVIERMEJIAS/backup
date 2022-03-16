package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "MODULOS_REFERENCIAS", schema = "dbo", catalog = "CRONOGRAMAS_INA2")
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

    public int getIdModuloReferencia() {
        return idModuloReferencia;
    }

    public void setIdModuloReferencia(int idModuloReferencia) {
        this.idModuloReferencia = idModuloReferencia;
    }

    public short getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(short idModulo) {
        this.idModulo = idModulo;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(int idReferencia) {
        this.idReferencia = idReferencia;
    }

    public String getDiasModuloReferencia() {
        return diasModuloReferencia;
    }

    public void setDiasModuloReferencia(String diasModuloReferencia) {
        this.diasModuloReferencia = diasModuloReferencia;
    }

    public String getHoraInicioModuloReferencia() {
        return horaInicioModuloReferencia;
    }

    public void setHoraInicioModuloReferencia(String horaInicioModuloReferencia) {
        this.horaInicioModuloReferencia = horaInicioModuloReferencia;
    }

    public String getHoraFinalModuloReferencia() {
        return horaFinalModuloReferencia;
    }

    public void setHoraFinalModuloReferencia(String horaFinalModuloReferencia) {
        this.horaFinalModuloReferencia = horaFinalModuloReferencia;
    }

    public Date getInicioModuloReferencia() {
        return inicioModuloReferencia;
    }

    public void setInicioModuloReferencia(Date inicioModuloReferencia) {
        this.inicioModuloReferencia = inicioModuloReferencia;
    }

    public Date getFinalModuloReferencia() {
        return finalModuloReferencia;
    }

    public void setFinalModuloReferencia(Date finalModuloReferencia) {
        this.finalModuloReferencia = finalModuloReferencia;
    }

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

    public Modulo getModulosByIdModulo() {
        return modulosByIdModulo;
    }

    public void setModulosByIdModulo(Modulo modulosByIdModulo) {
        this.modulosByIdModulo = modulosByIdModulo;
    }

    public Profesor getProfesoresByIdProfesor() {
        return profesoresByIdProfesor;
    }

    public void setProfesoresByIdProfesor(Profesor profesoresByIdProfesor) {
        this.profesoresByIdProfesor = profesoresByIdProfesor;
    }

    public Referencia getReferenciasByIdReferencia() {
        return referenciasByIdReferencia;
    }

    public void setReferenciasByIdReferencia(Referencia referenciasByIdReferencia) {
        this.referenciasByIdReferencia = referenciasByIdReferencia;
    }
}
