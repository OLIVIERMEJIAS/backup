/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.DAO;

import com.DeiviOlivier.CronogramaFase2.Dominios.DiaFeriado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDiaFeriadoDAO extends JpaRepository<DiaFeriado,Long>{
    public Iterable<DiaFeriado> findByNombreDiaFeriadoContains(String nom);
}
