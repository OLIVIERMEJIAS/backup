package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Provincia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PROVINCIA")
    private byte idProvincia;
    @Basic
    @Column(name = "NOMBRE_PROVINCIA")
    private String nombreProvincia;
    @OneToMany(mappedBy = "provinciasByIdProvincia")
    private Collection<Canton> cantonesByIdProvincia;

    public byte getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(byte idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Provincia that = (Provincia) o;

        if (idProvincia != that.idProvincia) return false;
        if (nombreProvincia != null ? !nombreProvincia.equals(that.nombreProvincia) : that.nombreProvincia != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idProvincia;
        result = 31 * result + (nombreProvincia != null ? nombreProvincia.hashCode() : 0);
        return result;
    }

    public Collection<Canton> getCantonesByIdProvincia() {
        return cantonesByIdProvincia;
    }

    public void setCantonesByIdProvincia(Collection<Canton> cantonesByIdProvincia) {
        this.cantonesByIdProvincia = cantonesByIdProvincia;
    }
}
