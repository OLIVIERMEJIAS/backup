package com.DeiviOlivier.CronogramaFase2.Dominios;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotEmpty(message="El nombre del programa es obligatorio")
    private String nombrePrograma;
    @Basic
    @Column(name = "CODIGO_PROGRAMA")
    @NotEmpty(message="El codigo es obligatorio")
    private String codigoPrograma;
    @Basic
    @Column(name = "HORAS_TOTALES")
    @NotNull(message="La cantidad de horas no debe estar vacía")
    @Min(value=1, message="La cantidad debe ser mayor a 0")
    private short horasTotales;
    @OneToMany(mappedBy = "programasByIdPrograma")
    private Collection<ModulosProgramas> modulosProgramasByIdPrograma;
    @OneToMany(mappedBy = "programaReferencia")
    private Collection<Referencia> referenciasByIdPrograma;

}
