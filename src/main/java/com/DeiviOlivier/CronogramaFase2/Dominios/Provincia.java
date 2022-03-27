package com.DeiviOlivier.CronogramaFase2.Dominios;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import lombok.Data;

@Data
@Entity
@Table(name="PROVINCIAS")
public class Provincia implements Serializable {
    private static final long serialVersionUID=1L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PROVINCIA")
    private byte idProvincia;
    @Basic
    @Column(name = "NOMBRE_PROVINCIA")
    private String nombreProvincia;
    @OneToMany(mappedBy = "provinciasByIdProvincia")
    private Collection<Canton> cantonesByIdProvincia;
}
