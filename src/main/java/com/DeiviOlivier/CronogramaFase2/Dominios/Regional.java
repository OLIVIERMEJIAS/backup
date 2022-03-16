package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Regional {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_REGIONAL")
    private byte idRegional;
    @Basic
    @Column(name = "NOMBRE_REGIONAL")
    private String nombreRegional;
    @OneToMany(mappedBy = "regionalesByIdRegional")
    private Collection<CentroFormacion> centrosFormacionesByIdRegional;

    public byte getIdRegional() {
        return idRegional;
    }

    public void setIdRegional(byte idRegional) {
        this.idRegional = idRegional;
    }

    public String getNombreRegional() {
        return nombreRegional;
    }

    public void setNombreRegional(String nombreRegional) {
        this.nombreRegional = nombreRegional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Regional that = (Regional) o;

        if (idRegional != that.idRegional) return false;
        if (nombreRegional != null ? !nombreRegional.equals(that.nombreRegional) : that.nombreRegional != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idRegional;
        result = 31 * result + (nombreRegional != null ? nombreRegional.hashCode() : 0);
        return result;
    }

    public Collection<CentroFormacion> getCentrosFormacionesByIdRegional() {
        return centrosFormacionesByIdRegional;
    }

    public void setCentrosFormacionesByIdRegional(Collection<CentroFormacion> centrosFormacionesByIdRegional) {
        this.centrosFormacionesByIdRegional = centrosFormacionesByIdRegional;
    }
}
