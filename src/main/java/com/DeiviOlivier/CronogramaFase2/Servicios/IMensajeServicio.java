/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.Dominios.Mensaje;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IMensajeServicio {
    public  List<Mensaje> listar();
    public void guardar(Mensaje mensaje);
    public Mensaje obtenerMensaje(Long id);
    public void eliminar (Long id);
}
