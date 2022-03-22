/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.DAO.IProfesorDAO;
import com.DeiviOlivier.CronogramaFase2.Dominios.Profesor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesorServicio implements IProfesorServicio {

    @Autowired
    public IProfesorDAO profesorDAO;

    @Override
    @Transactional
    public void guardar(Profesor profesor) {
        profesorDAO.save(profesor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Profesor> listar() {
        return profesorDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Profesor> listar(String nombre, String apellido, String cedula) {
        return (List<Profesor>) profesorDAO.findByNombreProfesorContainsOrApellido1ProfesorContainsOrCedulaProfesorContains(nombre, apellido, cedula);
    }

    @Override
    public Profesor obtenerProfesor(Long idProfesor) {
        return profesorDAO.findById(idProfesor).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        profesorDAO.deleteById(id);
    }

}
