package com.DeiviOlivier.CronogramaFase2.Dominios;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import lombok.Data;
@Data
@Entity
@Table(name = "CENTROS_FORMACIONES")
public class CentroFormacion implements Serializable {
    private static final long serialVersionUID=1L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CENTRO_FORMACION")
    private short idCentroFormacion;
 
    @Basic
    @Column(name = "DIRECCION_EXACTA")
    private String direccionExacta;
    @Basic
    @Column(name = "NOMBRE_CENTRO_FORMACION")
    private String nombreCentroFormacion;
    @Basic
    @Column(name = "CODIGO_CENTRO_FORMACION")
    private String codigoCentroFormacion;
    @OneToMany(mappedBy = "centrosFormacionesByIdCentroFormacion")
    private Collection<Administrador> administradoresByIdCentroFormacion;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "ID_REGIONAL", nullable = false)
    private Regional regional;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "ID_DISTRITO", nullable = false)
    private Distrito distrito;
    
    @OneToMany(mappedBy = "centrosFormacionesByIdCentroFormacion")
    private Collection<DiaFeriado> diasFeriadosByIdCentroFormacion;

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CentroFormacion that = (CentroFormacion) o;

        if (idCentroFormacion != that.idCentroFormacion) return false;
        if (direccionExacta != null ? !direccionExacta.equals(that.direccionExacta) : that.direccionExacta != null)
            return false;
        if (nombreCentroFormacion != null ? !nombreCentroFormacion.equals(that.nombreCentroFormacion) : that.nombreCentroFormacion != null)
            return false;
        if (codigoCentroFormacion != null ? !codigoCentroFormacion.equals(that.codigoCentroFormacion) : that.codigoCentroFormacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idCentroFormacion;
        result = 31 * result + (direccionExacta != null ? direccionExacta.hashCode() : 0);
        result = 31 * result + (nombreCentroFormacion != null ? nombreCentroFormacion.hashCode() : 0);
        result = 31 * result + (codigoCentroFormacion != null ? codigoCentroFormacion.hashCode() : 0);
        return result;
    }

    
}
