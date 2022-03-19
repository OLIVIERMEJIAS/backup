package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Modulo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_MODULO")
    private short idModulo;
    @Basic
    @Column(name = "NOMBRE_MODULO")
    private String nombreModulo;
    @Basic
    @Column(name = "CODIGO_MODULO")
    private String codigoModulo;
    @Basic
    @Column(name = "HORAS_MODULO")
    private short horasModulo;
    @Basic
    @Column(name = "REQUISITO_MODULO")
    private String requisitoModulo;

    @OneToMany(mappedBy = "modulosByIdModulo")
    private Collection<ModulosProgramas> modulosProgramasByIdModulo;
    @OneToMany(mappedBy = "modulosByIdModulo")
    private Collection<ModuloReferencia> modulosReferenciasByIdModulo;

    public short getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(short idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public String getCodigoModulo() {
        return codigoModulo;
    }

    public void setCodigoModulo(String codigoModulo) {
        this.codigoModulo = codigoModulo;
    }

    public short getHorasModulo() {
        return horasModulo;
    }

    public void setHorasModulo(short horasModulo) {
        this.horasModulo = horasModulo;
    }

    public String getRequisitoModulo() {
        return requisitoModulo;
    }

    public void setRequisitoModulo(String requisitoModulo) {
        this.requisitoModulo = requisitoModulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Modulo modulos = (Modulo) o;

        if (idModulo != modulos.idModulo) return false;
        if (horasModulo != modulos.horasModulo) return false;
        if (nombreModulo != null ? !nombreModulo.equals(modulos.nombreModulo) : modulos.nombreModulo != null)
            return false;
        if (codigoModulo != null ? !codigoModulo.equals(modulos.codigoModulo) : modulos.codigoModulo != null)
            return false;
        if (requisitoModulo != null ? !requisitoModulo.equals(modulos.requisitoModulo) : modulos.requisitoModulo != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idModulo;
        result = 31 * result + (nombreModulo != null ? nombreModulo.hashCode() : 0);
        result = 31 * result + (codigoModulo != null ? codigoModulo.hashCode() : 0);
        result = 31 * result + (int) horasModulo;
        result = 31 * result + (requisitoModulo != null ? requisitoModulo.hashCode() : 0);
        return result;
    }



    public Collection<ModulosProgramas> getModulosProgramasByIdModulo() {
        return modulosProgramasByIdModulo;
    }

    public void setModulosProgramasByIdModulo(Collection<ModulosProgramas> modulosProgramasByIdModulo) {
        this.modulosProgramasByIdModulo = modulosProgramasByIdModulo;
    }

    public Collection<ModuloReferencia> getModulosReferenciasByIdModulo() {
        return modulosReferenciasByIdModulo;
    }

    public void setModulosReferenciasByIdModulo(Collection<ModuloReferencia> modulosReferenciasByIdModulo) {
        this.modulosReferenciasByIdModulo = modulosReferenciasByIdModulo;
    }
}
