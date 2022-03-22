/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.DAO;

import com.DeiviOlivier.CronogramaFase2.Dominios.ModuloReferencia;
import com.DeiviOlivier.CronogramaFase2.Dominios.Referencia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP
 */
public interface IModuloReferenciaDAO extends JpaRepository<ModuloReferencia,Long>{
    public List<ModuloReferencia> findByReferencia(Referencia referencia);
}
