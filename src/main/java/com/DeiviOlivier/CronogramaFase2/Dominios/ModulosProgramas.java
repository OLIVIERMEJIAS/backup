package com.DeiviOlivier.CronogramaFase2.Dominios;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "MODULOS_PROGRAMAS")
public class ModulosProgramas implements Serializable {
    private static final long serialVersionUID=1L;
    
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

}
