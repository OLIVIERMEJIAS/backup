/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.DAO.IMensajeDAO;
import com.DeiviOlivier.CronogramaFase2.Dominios.Mensaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class MensajeServicio implements IMensajeServicio{
    @Autowired
    private IMensajeDAO mensajeDao;
    @Override
    public List<Mensaje> listar() {
        
        return mensajeDao.findAll();
    }

    @Override
    public void actualizarRespuesta(String respuesta, Long idMensaje) {
        mensajeDao.actualizarRespuesta(respuesta, idMensaje);
    }
    
    @Override
    public Mensaje obtenerMensaje(Long id){
        return mensajeDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        mensajeDao.deleteById(id);
    }
    
    
    
}
