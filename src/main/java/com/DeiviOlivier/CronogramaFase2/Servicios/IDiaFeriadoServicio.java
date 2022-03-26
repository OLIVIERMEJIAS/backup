/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.Dominios.DiaFeriado;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IDiaFeriadoServicio {
    public void guardar(DiaFeriado dia);

    public List<DiaFeriado> listar();

    public List<DiaFeriado> listar(String nombre);

    public DiaFeriado obtenerDia(Long idDiaFeriado);
    
    public void eliminar(Long id);
}
