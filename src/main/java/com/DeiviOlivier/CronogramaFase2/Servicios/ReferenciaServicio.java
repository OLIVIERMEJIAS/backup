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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Service
public class ReferenciaServicio implements IReferenciaServicio{
    
    @Autowired
    private IReferenciaDAO referenciaDAO;
    @Override
    @Transactional
    public void eliminar(Long id) {
        referenciaDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void guardar(Referencia referencia) {
        referenciaDAO.save(referencia);
    }

    @Override
    @Transactional(readOnly = true)
    public Referencia obtenerReferencia(Long id) {
        return referenciaDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Referencia> listar() {
        return referenciaDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Referencia> filtrar(String codigo) {
        return referenciaDAO.findByCodigo(codigo);
    }
    
}
