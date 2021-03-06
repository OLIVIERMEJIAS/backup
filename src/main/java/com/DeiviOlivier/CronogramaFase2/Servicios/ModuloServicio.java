/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.DAO.IModuloDAO;
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
public class ModuloServicio implements IModuloServicio{

    @Autowired
    private IModuloDAO moduloDao;
    
    @Override
    @Transactional
    public void guardar(Modulo modulo) {
        moduloDao.save(modulo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Modulo> listar() {
        return moduloDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Modulo> listar(String nombre, String codigo) {
        return (List<Modulo>) moduloDao.findByNombreModuloContainsOrCodigoModulo(nombre, codigo);
    }

    @Override
    public Modulo obtenerModulo(Long idModulo) {
        return moduloDao.findById(idModulo).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        moduloDao.deleteById(id);
    }

    @Override
    public List<Modulo> listar(Referencia referencia) {
        return (List<Modulo>) moduloDao.findByReferencia(referencia);
    }

    @Override
    public List<Modulo> listar(Long idPrograma) {
        return (List<Modulo>) moduloDao.modulosProgramas(idPrograma);
    }

    

}
