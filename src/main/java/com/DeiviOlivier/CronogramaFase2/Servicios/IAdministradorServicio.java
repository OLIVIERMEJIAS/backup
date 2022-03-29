/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.Dominios.Administrador;

/**
 *
 * @author HP
 */
public interface IAdministradorServicio {
    public void guardar(Administrador administrador);
    public Administrador obtenerAdministrador(Long id);
}
