/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.DAO.IAdministradorDAO;
import com.DeiviOlivier.CronogramaFase2.Dominios.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Service
public class AdministradorServicio implements IAdministradorServicio{
    @Autowired
    private IAdministradorDAO adminDao;
    @Override
    @Transactional
    public void guardar(Administrador administrador) {
        adminDao.save(administrador);
     }

    @Override
    @Transactional
    public Administrador obtenerAdministrador(Long id) {
        return adminDao.findById(id).orElse(null);
    }
    
}
