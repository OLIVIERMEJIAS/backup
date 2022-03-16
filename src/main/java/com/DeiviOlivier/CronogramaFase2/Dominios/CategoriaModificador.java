package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CATEGORIAS_MODIFICADORES", schema = "dbo", catalog = "CRONOGRAMAS_INA2")
public class CategoriaModificador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CATEGORIA_MODIFICADOR")
    private byte idCategoriaModificador;
    @Basic
    @Column(name = "NOMBRE_CATEGORIA_MODIFICADOR")
    private String nombreCategoriaModificador;
    @OneToMany(mappedBy = "categoriasModificadoresByIdCategoriaModificador")
    private Collection<Modificador> modificadoresByIdCategoriaModificador;

    public byte getIdCategoriaModificador() {
        return idCategoriaModificador;
    }

    public void setIdCategoriaModificador(byte idCategoriaModificador) {
        this.idCategoriaModificador = idCategoriaModificador;
    }

    public String getNombreCategoriaModificador() {
        return nombreCategoriaModificador;
    }

    public void setNombreCategoriaModificador(String nombreCategoriaModificador) {
        this.nombreCategoriaModificador = nombreCategoriaModificador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoriaModificador that = (CategoriaModificador) o;

        if (idCategoriaModificador != that.idCategoriaModificador) return false;
        if (nombreCategoriaModificador != null ? !nombreCategoriaModificador.equals(that.nombreCategoriaModificador) : that.nombreCategoriaModificador != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idCategoriaModificador;
        result = 31 * result + (nombreCategoriaModificador != null ? nombreCategoriaModificador.hashCode() : 0);
        return result;
    }

    public Collection<Modificador> getModificadoresByIdCategoriaModificador() {
        return modificadoresByIdCategoriaModificador;
    }

    public void setModificadoresByIdCategoriaModificador(Collection<Modificador> modificadoresByIdCategoriaModificador) {
        this.modificadoresByIdCategoriaModificador = modificadoresByIdCategoriaModificador;
    }
}
