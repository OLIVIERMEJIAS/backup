package com.DeiviOlivier.CronogramaFase2.Dominios;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import lombok.Data;
@Data
@Entity
@Table(name="DISTRITOS")
public class Distrito implements Serializable {
    private static final long serialVersionUID=1L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_DISTRITO")
    private short idDistrito;
    @Basic
    @Column(name = "NOMBRE_DISTRITO")
    private String nombreDistrito;

    @OneToMany(mappedBy = "distrito")
    private Collection<CentroFormacion> centrosFormacionesByIdDistrito;
    @ManyToOne
    @JoinColumn(name = "ID_CANTON", nullable = false)
    private Canton canton;

    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Distrito distritos = (Distrito) o;

        if (idDistrito != distritos.idDistrito) return false;
        if (nombreDistrito != null ? !nombreDistrito.equals(distritos.nombreDistrito) : distritos.nombreDistrito != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idDistrito;
        result = 31 * result + (nombreDistrito != null ? nombreDistrito.hashCode() : 0);
        return result;
    }


}
