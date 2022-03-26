/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.DAO.IModificadorDAO;
import com.DeiviOlivier.CronogramaFase2.Dominios.Modificador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModificadorServicio implements IModificadorServicio{

    @Autowired
    public IModificadorDAO modificadorDAO;
    
    @Override
    @Transactional
    public void guardar(Modificador modificador) {
        modificadorDAO.save(modificador);
    }

    @Override
    public List<Modificador> listar() {
        return modificadorDAO.findAll();
    }


    @Override
    public Modificador obtenerModificador(Long idModificador) {
        return modificadorDAO.findById(idModificador).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        modificadorDAO.deleteById(id);
    }

    @Override
    public List<Modificador> listar(String nombre, String nombreCategoria) {
      return (List<Modificador>) modificadorDAO.buscarPorNombreProfesorCategoria(nombre, nombreCategoria);
    }

  
    
}
