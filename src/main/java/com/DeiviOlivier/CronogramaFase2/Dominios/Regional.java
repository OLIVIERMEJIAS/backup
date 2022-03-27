package com.DeiviOlivier.CronogramaFase2.Dominios;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import lombok.Data;

@Data
@Entity
@Table(name="REGIONALES")
public class Regional implements Serializable {
    private static final long serialVersionUID=1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_REGIONAL")
    private byte idRegional;
    @Basic
    @Column(name = "NOMBRE_REGIONAL")
    private String nombreRegional;
    @OneToMany(mappedBy = "regionalesByIdRegional")
    private Collection<CentroFormacion> centrosFormacionesByIdRegional;


}
