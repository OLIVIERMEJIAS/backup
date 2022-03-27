package com.DeiviOlivier.CronogramaFase2.Dominios;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import lombok.Data;
@Data
@Entity
@Table(name="PROGRAMAS")
public class Programa implements Serializable{
    private static final long serialVersionUID=1L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PROGRAMA")
    private Long idPrograma;
    @Basic
    @Column(name = "NOMBRE_PROGRAMA")
    private String nombrePrograma;
    @Basic
    @Column(name = "CODIGO_PROGRAMA")
    private String codigoPrograma;
    @Basic
    @Column(name = "HORAS_TOTALES")
    private short horasTotales;
    @OneToMany(mappedBy = "programasByIdPrograma")
    private Collection<ModulosProgramas> modulosProgramasByIdPrograma;
    @OneToMany(mappedBy = "programaReferencia")
    private Collection<Referencia> referenciasByIdPrograma;

}
