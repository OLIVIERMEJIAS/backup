/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.DAO.IReferenciaDAO;
import com.DeiviOlivier.CronogramaFase2.Dominios.Modulo;
import com.DeiviOlivier.CronogramaFase2.Dominios.Programa;
import com.DeiviOlivier.CronogramaFase2.Dominios.Referencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class ReferenciaServicio implements IReferenciaServicio{
    
    @Autowired
    private IReferenciaDAO referenciaDAO;
    @Override
    public void eliminar(Long id) {
        referenciaDAO.deleteById(id);
    }

    @Override
    public void guardar(Referencia referencia) {
        referenciaDAO.save(referencia);
    }

    @Override
    public Referencia obtenerReferencia(Long id) {
        return referenciaDAO.findById(id).orElse(null);
    }

    @Override
    public List<Referencia> listar() {
        return referenciaDAO.findAll();
    }

    @Override
    public List<Referencia> filtrar(String codigo, Programa programa, Modulo modulo) {
        return referenciaDAO.findByReferenciaOrProgramaOrModulo(codigo, programa, modulo);
    }
    
}
