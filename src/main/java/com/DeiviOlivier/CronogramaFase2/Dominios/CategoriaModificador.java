package com.DeiviOlivier.CronogramaFase2.Dominios;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import lombok.Data;
@Data
@Entity
@Table(name = "CATEGORIAS_MODIFICADORES")
public class CategoriaModificador implements Serializable {
    private static final long serialVersionUID=1L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CATEGORIA_MODIFICADOR")
    private byte idCategoriaModificador;
    @Basic
    @Column(name = "NOMBRE_CATEGORIA_MODIFICADOR")
    private String nombreCategoriaModificador;
    @OneToMany(mappedBy = "categoriasModificadoresByIdCategoriaModificador")
    private Collection<Modificador> modificadoresByIdCategoriaModificador;

    
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

    
}
