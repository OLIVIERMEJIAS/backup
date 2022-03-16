package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class ModulosProgramasPK implements Serializable {
    @Column(name = "ID_PROGRAMA")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idPrograma;
    @Column(name = "ID_MODULO")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idModulo;

    public short getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(short idPrograma) {
        this.idPrograma = idPrograma;
    }

    public short getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(short idModulo) {
        this.idModulo = idModulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModulosProgramasPK that = (ModulosProgramasPK) o;

        if (idPrograma != that.idPrograma) return false;
        if (idModulo != that.idModulo) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idPrograma;
        result = 31 * result + (int) idModulo;
        return result;
    }
}
