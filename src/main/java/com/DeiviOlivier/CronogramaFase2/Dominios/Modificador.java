package com.DeiviOlivier.CronogramaFase2.Dominios;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import javax.validation.constraints.*;
import lombok.Data;
@Data
@Entity
@Table(name="MODIFICADORES")
public class Modificador implements Serializable {
    private static final long serialVersionUID=1L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotNull(message = "Este campo es obligatorio")
    @Column(name = "ID_MODIFICADOR")
    private Long idModificador;
    @Basic
    @NotNull(message = "Este campo es obligatorio")
    @Column(name = "INICIO_MODIFICADOR")
    private Date inicioModificador;
    @Basic
    @NotNull(message = "Este campo es obligatorio")
    @Column(name = "FINAL_MODIFICADOR")
    private Date finalModificador;
    @Basic
    @Column(name = "DESCRIPCION_MODIFICADOR")
    private String descripcionModificador;
    @ManyToOne
    @JoinColumn(name = "ID_PROFESOR", nullable = false)
    private Profesor profesoresModificadores;
    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA_MODIFICADOR", nullable = false)
    private CategoriaModificador categoriasModificadoresByIdCategoriaModificador;

}
