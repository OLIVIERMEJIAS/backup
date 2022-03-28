/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.DAO.IModuloReferenciaDAO;
import com.DeiviOlivier.CronogramaFase2.Dominios.ModuloReferencia;
import com.DeiviOlivier.CronogramaFase2.Dominios.Referencia;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Service
public class ModuloReferenciaServicio implements IModuloReferenciaServicio{
    @Autowired
    private IModuloReferenciaDAO modRedDao;
    @Override
    @Transactional
    public void eliminar(Long id) {
        modRedDao.deleteById(id);
    }

    @Override
    @Transactional
    public void eliminarPorReferencia(Referencia referencia) {
        modRedDao.deleteAllByReferencia(referencia);
    }
    
    
    
    @Override
    @Transactional
    public void guardar(ModuloReferencia moduloReferencia) {
        modRedDao.save(moduloReferencia);
    }

    @Override
    @Transactional(readOnly = true)
    public ModuloReferencia obtenerModuloReferencia(Long id) {
        return modRedDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ModuloReferencia> listar(Referencia referencia) {
        return modRedDao.findByReferencia(referencia);
    }

    @Override
    @Transactional
    public HashMap verificarHorarioProfesor(int idProfesor, String respuesta, String msg, String diasEntrada, String horaEntradaInicio, String horaEntradaFin, Date fechaIniEntrada, Date fechaFinEntrada, int idModEntrada) {
        return modRedDao.sp_verificarHorario_(idProfesor, respuesta, msg, diasEntrada, horaEntradaInicio, horaEntradaFin, fechaIniEntrada, fechaFinEntrada, idModEntrada);
    }

    @Override
    @Transactional
    public void calcular(long idReferencia, long idCentro) {
        modRedDao.calcular(idReferencia, idCentro);
    }
    
}
