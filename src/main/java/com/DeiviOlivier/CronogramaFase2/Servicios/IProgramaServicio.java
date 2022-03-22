/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.Dominios.Programa;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IProgramaServicio {
    public void guardar(Programa programa);

    public List<Programa> listar();

    public List<Programa> listar(String nombre, String codigo);

    public Programa obtenerPrograma(Long idModulo);
    
    public void eliminar(Long id);
}
