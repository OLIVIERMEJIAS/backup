package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Canton {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CANTON")
    private byte idCanton;
    @Basic
    @Column(name = "NOMBRE_CANTON")
    private String nombreCanton;
    @Basic
    @Column(name = "ID_PROVINCIA")
    private byte idProvincia;
    @ManyToOne
    @JoinColumn(name = "ID_PROVINCIA", referencedColumnName = "ID_PROVINCIA", nullable = false)
    private Provincia provinciasByIdProvincia;
    @OneToMany(mappedBy = "cantonesByIdCanton")
    private Collection<Distrito> distritosByIdCanton;

    public byte getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(byte idCanton) {
        this.idCanton = idCanton;
    }

    public String getNombreCanton() {
        return nombreCanton;
    }

    public void setNombreCanton(String nombreCanton) {
        this.nombreCanton = nombreCanton;
    }

    public byte getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(byte idProvincia) {
        this.idProvincia = idProvincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Canton cantones = (Canton) o;

        if (idCanton != cantones.idCanton) return false;
        if (idProvincia != cantones.idProvincia) return false;
        if (nombreCanton != null ? !nombreCanton.equals(cantones.nombreCanton) : cantones.nombreCanton != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idCanton;
        result = 31 * result + (nombreCanton != null ? nombreCanton.hashCode() : 0);
        result = 31 * result + (int) idProvincia;
        return result;
    }

    public Provincia getProvinciasByIdProvincia() {
        return provinciasByIdProvincia;
    }

    public void setProvinciasByIdProvincia(Provincia provinciasByIdProvincia) {
        this.provinciasByIdProvincia = provinciasByIdProvincia;
    }

    public Collection<Distrito> getDistritosByIdCanton() {
        return distritosByIdCanton;
    }

    public void setDistritosByIdCanton(Collection<Distrito> distritosByIdCanton) {
        this.distritosByIdCanton = distritosByIdCanton;
    }
}
