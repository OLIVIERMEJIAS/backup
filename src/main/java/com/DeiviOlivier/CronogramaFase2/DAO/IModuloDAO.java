/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.DAO;

import com.DeiviOlivier.CronogramaFase2.Dominios.Modulo;
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

}
