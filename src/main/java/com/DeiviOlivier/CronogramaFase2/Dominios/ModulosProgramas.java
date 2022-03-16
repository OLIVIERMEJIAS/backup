package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;

@Entity
@Table(name = "MODULOS_PROGRAMAS", schema = "dbo", catalog = "CRONOGRAMAS_INA2")
@IdClass(ModulosProgramasPK.class)
public class ModulosProgramas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PROGRAMA")
    private short idPrograma;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_MODULO")
    private short idModulo;
    @ManyToOne
    @JoinColumn(name = "ID_PROGRAMA", referencedColumnName = "ID_PROGRAMA", nullable = false)
    private Programa programasByIdPrograma;
    @ManyToOne
    @JoinColumn(name = "ID_MODULO", referencedColumnName = "ID_MODULO", nullable = false)
    private Modulo modulosByIdModulo;

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

        ModulosProgramas that = (ModulosProgramas) o;

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

    public Programa getProgramasByIdPrograma() {
        return programasByIdPrograma;
    }

    public void setProgramasByIdPrograma(Programa programasByIdPrograma) {
        this.programasByIdPrograma = programasByIdPrograma;
    }

    public Modulo getModulosByIdModulo() {
        return modulosByIdModulo;
    }

    public void setModulosByIdModulo(Modulo modulosByIdModulo) {
        this.modulosByIdModulo = modulosByIdModulo;
    }
}
