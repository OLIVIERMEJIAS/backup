/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.DAO.IDiaFeriadoDAO;
import com.DeiviOlivier.CronogramaFase2.Dominios.DiaFeriado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Service
public class DiaFeriadoServicio implements IDiaFeriadoServicio{

    @Autowired
    private IDiaFeriadoDAO diaDao;
    
    @Override
    @Transactional
    public void guardar(DiaFeriado dia) {
        diaDao.save(dia);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DiaFeriado> listar() {
        return diaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<DiaFeriado> listar(String nombre) {
        return (List<DiaFeriado>) diaDao.findByNombreDiaFeriadoContains(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public DiaFeriado obtenerDia(Long idDiaFeriado) {
        return diaDao.findById(idDiaFeriado).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        diaDao.deleteById(id);
    }
    
}
