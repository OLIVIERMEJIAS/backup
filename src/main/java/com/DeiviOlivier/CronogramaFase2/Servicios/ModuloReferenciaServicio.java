/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.DAO.IModuloReferenciaDAO;
import com.DeiviOlivier.CronogramaFase2.Dominios.ModuloReferencia;
import com.DeiviOlivier.CronogramaFase2.Dominios.Referencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class ModuloReferenciaServicio implements IModuloReferenciaServicio{
    @Autowired
    private IModuloReferenciaDAO modRedDao;
    @Override
    public void eliminar(Long id) {
        modRedDao.deleteById(id);
    }

    @Override
    public void eliminarPorReferencia(Referencia referencia) {
        modRedDao.deleteByReferencia(referencia);
    }
    
    
    
    @Override
    public void guardar(ModuloReferencia moduloReferencia) {
        modRedDao.save(moduloReferencia);
    }

    @Override
    public ModuloReferencia obtenerModuloReferencia(Long id) {
        return modRedDao.findById(id).orElse(null);
    }

    @Override
    public List<ModuloReferencia> listar(Referencia referencia) {
        return modRedDao.findByReferencia(referencia);
    }
    
}
