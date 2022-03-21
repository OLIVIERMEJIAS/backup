package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.util.Collection;
import lombok.Data;
@Data
@Entity
@Table(name="MODULOS")
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
    @OneToMany(mappedBy = "modulosReferencia")
    private Collection<ModuloReferencia> modulosReferenciasByIdModulo;
    @OneToMany(mappedBy = "moduloReferencia")
    private Collection<Referencia> referenciasByIdModulo;

    
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

}
