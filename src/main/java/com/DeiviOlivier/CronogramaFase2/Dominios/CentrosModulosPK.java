package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class CentrosModulosPK implements Serializable {
    @Column(name = "ID_MODULO")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idModulo;
    @Column(name = "ID_CENTRO_FORMACION")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idCentroFormacion;

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

        CentrosModulosPK that = (CentrosModulosPK) o;

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
}
