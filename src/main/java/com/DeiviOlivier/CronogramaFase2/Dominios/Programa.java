package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.util.Collection;
import lombok.Data;
@Data
@Entity
@Table(name="PROGRAMAS")
public class Programa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PROGRAMA")
    private short idPrograma;
    @Basic
    @Column(name = "NOMBRE_PROGRAMA")
    private String nombrePrograma;
    @Basic
    @Column(name = "CODIGO_PROGRAMA")
    private String codigoPrograma;
    @Basic
    @Column(name = "HORAS_TOTALES")
    private short horasTotales;
    @OneToMany(mappedBy = "programasByIdPrograma")
    private Collection<ModulosProgramas> modulosProgramasByIdPrograma;
    @OneToMany(mappedBy = "programasByIdPrograma")
    private Collection<Referencia> referenciasByIdPrograma;

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Programa programas = (Programa) o;

        if (idPrograma != programas.idPrograma) return false;
        if (horasTotales != programas.horasTotales) return false;
        if (nombrePrograma != null ? !nombrePrograma.equals(programas.nombrePrograma) : programas.nombrePrograma != null)
            return false;
        if (codigoPrograma != null ? !codigoPrograma.equals(programas.codigoPrograma) : programas.codigoPrograma != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idPrograma;
        result = 31 * result + (nombrePrograma != null ? nombrePrograma.hashCode() : 0);
        result = 31 * result + (codigoPrograma != null ? codigoPrograma.hashCode() : 0);
        result = 31 * result + (int) horasTotales;
        return result;
    }


}
