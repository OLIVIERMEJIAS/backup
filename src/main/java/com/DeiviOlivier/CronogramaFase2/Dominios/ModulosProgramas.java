package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "MODULOS_PROGRAMAS")
public class ModulosProgramas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="ID_MODULO_PROGRAMA")
    private int idModuloPrograma;
    @ManyToOne
    @JoinColumn(name = "ID_PROGRAMA", nullable = false)
    private Programa programasByIdPrograma;
    @ManyToOne
    @JoinColumn(name = "ID_MODULO", nullable = false)
    private Modulo modulosByIdModulo;

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModulosProgramas that = (ModulosProgramas) o;


        return true;
    }

   

    
}
