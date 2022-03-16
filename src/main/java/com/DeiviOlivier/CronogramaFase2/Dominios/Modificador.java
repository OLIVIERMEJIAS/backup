package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Modificador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_MODIFICADOR")
    private int idModificador;
    @Basic
    @Column(name = "ID_PROFESOR")
    private int idProfesor;
    @Basic
    @Column(name = "ID_CATEGORIA_MODIFICADOR")
    private byte idCategoriaModificador;
    @Basic
    @Column(name = "INICIO_MODIFICADOR")
    private Date inicioModificador;
    @Basic
    @Column(name = "FINAL_MODIFICADOR")
    private Date finalModificador;
    @Basic
    @Column(name = "DESCRIPCION_MODIFICADOR")
    private String descripcionModificador;
    @ManyToOne
    @JoinColumn(name = "ID_PROFESOR", referencedColumnName = "ID_PROFESOR", nullable = false)
    private Profesor profesoresByIdProfesor;
    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA_MODIFICADOR", referencedColumnName = "ID_CATEGORIA_MODIFICADOR", nullable = false)
    private CategoriaModificador categoriasModificadoresByIdCategoriaModificador;

    public int getIdModificador() {
        return idModificador;
    }

    public void setIdModificador(int idModificador) {
        this.idModificador = idModificador;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public byte getIdCategoriaModificador() {
        return idCategoriaModificador;
    }

    public void setIdCategoriaModificador(byte idCategoriaModificador) {
        this.idCategoriaModificador = idCategoriaModificador;
    }

    public Date getInicioModificador() {
        return inicioModificador;
    }

    public void setInicioModificador(Date inicioModificador) {
        this.inicioModificador = inicioModificador;
    }

    public Date getFinalModificador() {
        return finalModificador;
    }

    public void setFinalModificador(Date finalModificador) {
        this.finalModificador = finalModificador;
    }

    public String getDescripcionModificador() {
        return descripcionModificador;
    }

    public void setDescripcionModificador(String descripcionModificador) {
        this.descripcionModificador = descripcionModificador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Modificador that = (Modificador) o;

        if (idModificador != that.idModificador) return false;
        if (idProfesor != that.idProfesor) return false;
        if (idCategoriaModificador != that.idCategoriaModificador) return false;
        if (inicioModificador != null ? !inicioModificador.equals(that.inicioModificador) : that.inicioModificador != null)
            return false;
        if (finalModificador != null ? !finalModificador.equals(that.finalModificador) : that.finalModificador != null)
            return false;
        if (descripcionModificador != null ? !descripcionModificador.equals(that.descripcionModificador) : that.descripcionModificador != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idModificador;
        result = 31 * result + idProfesor;
        result = 31 * result + (int) idCategoriaModificador;
        result = 31 * result + (inicioModificador != null ? inicioModificador.hashCode() : 0);
        result = 31 * result + (finalModificador != null ? finalModificador.hashCode() : 0);
        result = 31 * result + (descripcionModificador != null ? descripcionModificador.hashCode() : 0);
        return result;
    }

    public Profesor getProfesoresByIdProfesor() {
        return profesoresByIdProfesor;
    }

    public void setProfesoresByIdProfesor(Profesor profesoresByIdProfesor) {
        this.profesoresByIdProfesor = profesoresByIdProfesor;
    }

    public CategoriaModificador getCategoriasModificadoresByIdCategoriaModificador() {
        return categoriasModificadoresByIdCategoriaModificador;
    }

    public void setCategoriasModificadoresByIdCategoriaModificador(CategoriaModificador categoriasModificadoresByIdCategoriaModificador) {
        this.categoriasModificadoresByIdCategoriaModificador = categoriasModificadoresByIdCategoriaModificador;
    }
}
