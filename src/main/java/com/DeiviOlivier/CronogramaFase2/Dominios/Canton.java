package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.util.Collection;
import lombok.Data;
@Data
@Entity
@Table(name="CANTONES")
public class Canton {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CANTON")
    private byte idCanton;
    @Basic
    @Column(name = "NOMBRE_CANTON")
    private String nombreCanton;

    @ManyToOne
    @JoinColumn(name = "ID_PROVINCIA", nullable = false)
    private Provincia provinciasByIdProvincia;
    @OneToMany(mappedBy = "cantonesByIdCanton")
    private Collection<Distrito> distritosByIdCanton;

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Canton cantones = (Canton) o;

        if (idCanton != cantones.idCanton) return false;
        if (nombreCanton != null ? !nombreCanton.equals(cantones.nombreCanton) : cantones.nombreCanton != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idCanton;
        result = 31 * result + (nombreCanton != null ? nombreCanton.hashCode() : 0);
        return result;
    }


}
