/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.DAO;

import com.DeiviOlivier.CronogramaFase2.Dominios.Modulo;
import com.DeiviOlivier.CronogramaFase2.Dominios.Programa;
import com.DeiviOlivier.CronogramaFase2.Dominios.Referencia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
public interface IReferenciaDAO extends JpaRepository<Referencia,Long>{
    
   public List<Referencia> findByCodigo(String codigo);
   @Modifying
  @Transactional
   @Query(value="UPDATE REFERENCIAS SET ID_MODULO = ?1 WHERE ID_REFERENCIA = ?2",nativeQuery = true)
   public int asociarModulo(Long idModulo, Long idReferencia);
   @Modifying
  @Transactional
   @Query(value="UPDATE REFERENCIAS SET ID_PROGRAMA = ?1 WHERE ID_REFERENCIA = ?2",nativeQuery = true)
   public int asociarPrograma(Long idPrograma, Long idReferencia);
}
