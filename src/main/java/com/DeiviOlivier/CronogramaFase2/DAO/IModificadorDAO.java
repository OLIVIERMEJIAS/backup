/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.DAO;

import com.DeiviOlivier.CronogramaFase2.Dominios.Modificador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author HP
 */
public interface IModificadorDAO extends JpaRepository<Modificador, Long> {
    @Modifying
    @Query(value = "Select M.ID_MODIFICADOR,M.ID_PROFESOR,M.ID_CATEGORIA_MODIFICADOR,M.INICIO_MODIFICADOR,M.FINAL_MODIFICADOR, M.DESCRIPCION_MODIFICADOR from Modificadores M inner join Profesores P on M.ID_Profesor = P.ID_Profesor\n"
            + "inner Join CATEGORIAS_MODIFICADORES C on C.Id_Categoria_Modificador = M.Id_Categoria_Modificador\n"
            + "where P.Nombre_Profesor LIKE ?1% or C.NOMBRE_CATEGORIA_MODIFICADOR LIKE ?2%",nativeQuery = true)
    public Iterable<Modificador> buscarPorNombreProfesorCategoria(String nombre, String categoria);
}
