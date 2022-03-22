/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.DAO;

import com.DeiviOlivier.CronogramaFase2.Dominios.Modulo;
import com.DeiviOlivier.CronogramaFase2.Dominios.Programa;
import com.DeiviOlivier.CronogramaFase2.Dominios.Referencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface IModuloDAO extends JpaRepository<Modulo, Long>{
    //Método Personalizado Spring Data
    public Iterable<Modulo> findByNombreModuloContainsOrCodigoModulo(String nom, String cod);
    
    public Iterable<Modulo> findByReferencia(Referencia referencia);
    @Modifying
    @Query(value="SELECT M.ID_MODULO,M.NOMBRE_MODULO,M.CODIGO_MODULO,"
            + "M.HORAS_MODULO,M.REQUISITO_MODULO FROM MODULOS M INNER JOIN MODULOS_PROGRAMAS MP ON"
            + " M.ID_MODULO = MP.ID_MODULO WHERE MP.ID_PROGRAMA = ?1",nativeQuery = true)
    public Iterable<Modulo> modulosProgramas(Long idPrograma);

}
