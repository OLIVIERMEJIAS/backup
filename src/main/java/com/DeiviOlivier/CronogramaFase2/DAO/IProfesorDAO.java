/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.DAO;

import com.DeiviOlivier.CronogramaFase2.Dominios.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfesorDAO extends JpaRepository<Profesor,Long>{
    public Iterable<Profesor> findByNombreProfesorContainsOrApellido1ProfesorContainsOrCedulaProfesorContains(String nom, String ape,String cedula);
}
