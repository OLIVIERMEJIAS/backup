/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.Dominios.Modulo;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
public interface IModuloServicio {

    public void guardar(Modulo modulo);

    public List<Modulo> listar();

    public List<Modulo> listar(String nombre, String codigo);

    public Modulo obtenerModulo(Long idModulo);
    
    public void eliminar(Long id);
}
