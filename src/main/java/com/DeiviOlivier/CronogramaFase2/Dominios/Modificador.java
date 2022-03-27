package com.DeiviOlivier.CronogramaFase2.Dominios;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import lombok.Data;
@Data
@Entity
@Table(name="MODIFICADORES")
public class Modificador implements Serializable {
    private static final long serialVersionUID=1L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_MODIFICADOR")
    private Long idModificador;
    @Basic
    @Column(name = "INICIO_MODIFICADOR")
    private Date inicioModificador;
    @Basic
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
