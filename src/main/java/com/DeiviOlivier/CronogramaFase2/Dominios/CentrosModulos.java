package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;

@Entity
@Table(name = "CENTROS_MODULOS", schema = "dbo", catalog = "CRONOGRAMAS_INA2")
@IdClass(CentrosModulosPK.class)
public class CentrosModulos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_MODULO")
    private short idModulo;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CENTRO_FORMACION")
    private short idCentroFormacion;
    @ManyToOne
    @JoinColumn(name = "ID_MODULO", referencedColumnName = "ID_MODULO", nullable = false)
    private Modulo modulosByIdModulo;
    @ManyToOne
    @JoinColumn(name = "ID_CENTRO_FORMACION", referencedColumnName = "ID_CENTRO_FORMACION", nullable = false)
    private CentroFormacion centrosFormacionesByIdCentroFormacion;

    public short getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(short idModulo) {
        this.idModulo = idModulo;
    }

    public short getIdCentroFormacion() {
        return idCentroFormacion;
    }

    public void setIdCentroFormacion(short idCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CentrosModulos that = (CentrosModulos) o;

        if (idModulo != that.idModulo) return false;
        if (idCentroFormacion != that.idCentroFormacion) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idModulo;
        result = 31 * result + (int) idCentroFormacion;
        return result;
    }

    public Modulo getModulosByIdModulo() {
        return modulosByIdModulo;
    }

    public void setModulosByIdModulo(Modulo modulosByIdModulo) {
        this.modulosByIdModulo = modulosByIdModulo;
    }

    public CentroFormacion getCentrosFormacionesByIdCentroFormacion() {
        return centrosFormacionesByIdCentroFormacion;
    }

    public void setCentrosFormacionesByIdCentroFormacion(CentroFormacion centrosFormacionesByIdCentroFormacion) {
        this.centrosFormacionesByIdCentroFormacion = centrosFormacionesByIdCentroFormacion;
    }
}
