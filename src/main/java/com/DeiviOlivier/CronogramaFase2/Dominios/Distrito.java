package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Distrito {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_DISTRITO")
    private short idDistrito;
    @Basic
    @Column(name = "NOMBRE_DISTRITO")
    private String nombreDistrito;
    @Basic
    @Column(name = "ID_CANTON")
    private byte idCanton;
    @OneToMany(mappedBy = "distritosByIdDistrito")
    private Collection<CentroFormacion> centrosFormacionesByIdDistrito;
    @ManyToOne
    @JoinColumn(name = "ID_CANTON", referencedColumnName = "ID_CANTON", nullable = false)
    private Canton cantonesByIdCanton;

    public short getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(short idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public byte getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(byte idCanton) {
        this.idCanton = idCanton;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Distrito distritos = (Distrito) o;

        if (idDistrito != distritos.idDistrito) return false;
        if (idCanton != distritos.idCanton) return false;
        if (nombreDistrito != null ? !nombreDistrito.equals(distritos.nombreDistrito) : distritos.nombreDistrito != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idDistrito;
        result = 31 * result + (nombreDistrito != null ? nombreDistrito.hashCode() : 0);
        result = 31 * result + (int) idCanton;
        return result;
    }

    public Collection<CentroFormacion> getCentrosFormacionesByIdDistrito() {
        return centrosFormacionesByIdDistrito;
    }

    public void setCentrosFormacionesByIdDistrito(Collection<CentroFormacion> centrosFormacionesByIdDistrito) {
        this.centrosFormacionesByIdDistrito = centrosFormacionesByIdDistrito;
    }

    public Canton getCantonesByIdCanton() {
        return cantonesByIdCanton;
    }

    public void setCantonesByIdCanton(Canton cantonesByIdCanton) {
        this.cantonesByIdCanton = cantonesByIdCanton;
    }
}
