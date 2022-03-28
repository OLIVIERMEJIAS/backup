/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.Dominios.Profesor;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IProfesorServicio {
    public void guardar(Profesor profesor);

    public List<Profesor> listar();

    public List<Profesor> listar(String nombre, String apellido, String cedula);

    public Profesor obtenerProfesor(Long idProfesor);
    
    public void eliminar(Long id);
    
    public boolean existeEmail(String correo);
    
    public boolean existeCedula(String cedula);
}
