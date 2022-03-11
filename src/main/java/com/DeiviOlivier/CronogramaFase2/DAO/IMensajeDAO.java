/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.DAO;
import com.DeiviOlivier.CronogramaFase2.Dominios.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author HP
 */
public interface IMensajeDAO extends JpaRepository<Mensaje, Long>{
    
}
