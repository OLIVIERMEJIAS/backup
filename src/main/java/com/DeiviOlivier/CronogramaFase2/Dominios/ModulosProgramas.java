package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "MODULOS_PROGRAMAS")
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

    
}
