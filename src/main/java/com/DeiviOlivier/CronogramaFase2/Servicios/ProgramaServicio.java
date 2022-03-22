/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.DAO.IProgramaDAO;
import com.DeiviOlivier.CronogramaFase2.Dominios.Programa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProgramaServicio implements IProgramaServicio{

    
    @Autowired
    private IProgramaDAO programaDAO;
    
    
    @Override
    @Transactional
    public void guardar(Programa programa) {
        programaDAO.save(programa);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Programa> listar() {
        return programaDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Programa> listar(String nombre, String codigo) {
        return (List<Programa>) programaDAO.findByNombreProgramaContainsOrCodigoPrograma(nombre, codigo);
    }

    @Override
    public Programa obtenerPrograma(Long idModulo) {
        return programaDAO.findById(idModulo).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        programaDAO.deleteById(id);
    }
    
}
