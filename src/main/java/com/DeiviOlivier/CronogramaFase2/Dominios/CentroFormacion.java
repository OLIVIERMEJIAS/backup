package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CENTROS_FORMACIONES", schema = "dbo", catalog = "CRONOGRAMAS_INA2")
public class CentroFormacion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CENTRO_FORMACION")
    private short idCentroFormacion;
    @Basic
    @Column(name = "ID_REGIONAL")
    private byte idRegional;
    @Basic
    @Column(name = "ID_DISTRITO")
    private short idDistrito;
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
    @ManyToOne
    @JoinColumn(name = "ID_REGIONAL", referencedColumnName = "ID_REGIONAL", nullable = false)
    private Regional regionalesByIdRegional;
    @ManyToOne
    @JoinColumn(name = "ID_DISTRITO", referencedColumnName = "ID_DISTRITO", nullable = false)
    private Distrito distritosByIdDistrito;
    @OneToMany(mappedBy = "centrosFormacionesByIdCentroFormacion")
    private Collection<CentrosModulos> centrosModulosByIdCentroFormacion;
    @OneToMany(mappedBy = "centrosFormacionesByIdCentroFormacion")
    private Collection<DiaFeriado> diasFeriadosByIdCentroFormacion;

    public short getIdCentroFormacion() {
        return idCentroFormacion;
    }

    public void setIdCentroFormacion(short idCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
    }

    public byte getIdRegional() {
        return idRegional;
    }

    public void setIdRegional(byte idRegional) {
        this.idRegional = idRegional;
    }

    public short getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(short idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getDireccionExacta() {
        return direccionExacta;
    }

    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }

    public String getNombreCentroFormacion() {
        return nombreCentroFormacion;
    }

    public void setNombreCentroFormacion(String nombreCentroFormacion) {
        this.nombreCentroFormacion = nombreCentroFormacion;
    }

    public String getCodigoCentroFormacion() {
        return codigoCentroFormacion;
    }

    public void setCodigoCentroFormacion(String codigoCentroFormacion) {
        this.codigoCentroFormacion = codigoCentroFormacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CentroFormacion that = (CentroFormacion) o;

        if (idCentroFormacion != that.idCentroFormacion) return false;
        if (idRegional != that.idRegional) return false;
        if (idDistrito != that.idDistrito) return false;
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
        result = 31 * result + (int) idRegional;
        result = 31 * result + (int) idDistrito;
        result = 31 * result + (direccionExacta != null ? direccionExacta.hashCode() : 0);
        result = 31 * result + (nombreCentroFormacion != null ? nombreCentroFormacion.hashCode() : 0);
        result = 31 * result + (codigoCentroFormacion != null ? codigoCentroFormacion.hashCode() : 0);
        return result;
    }

    public Collection<Administrador> getAdministradoresByIdCentroFormacion() {
        return administradoresByIdCentroFormacion;
    }

    public void setAdministradoresByIdCentroFormacion(Collection<Administrador> administradoresByIdCentroFormacion) {
        this.administradoresByIdCentroFormacion = administradoresByIdCentroFormacion;
    }

    public Regional getRegionalesByIdRegional() {
        return regionalesByIdRegional;
    }

    public void setRegionalesByIdRegional(Regional regionalesByIdRegional) {
        this.regionalesByIdRegional = regionalesByIdRegional;
    }

    public Distrito getDistritosByIdDistrito() {
        return distritosByIdDistrito;
    }

    public void setDistritosByIdDistrito(Distrito distritosByIdDistrito) {
        this.distritosByIdDistrito = distritosByIdDistrito;
    }

    public Collection<CentrosModulos> getCentrosModulosByIdCentroFormacion() {
        return centrosModulosByIdCentroFormacion;
    }

    public void setCentrosModulosByIdCentroFormacion(Collection<CentrosModulos> centrosModulosByIdCentroFormacion) {
        this.centrosModulosByIdCentroFormacion = centrosModulosByIdCentroFormacion;
    }

    public Collection<DiaFeriado> getDiasFeriadosByIdCentroFormacion() {
        return diasFeriadosByIdCentroFormacion;
    }

    public void setDiasFeriadosByIdCentroFormacion(Collection<DiaFeriado> diasFeriadosByIdCentroFormacion) {
        this.diasFeriadosByIdCentroFormacion = diasFeriadosByIdCentroFormacion;
    }
}
