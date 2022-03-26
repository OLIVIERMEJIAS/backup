/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.Dominios.Modificador;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IModificadorServicio {
    public void guardar(Modificador profesor);

    public List<Modificador> listar();
    
    public List<Modificador> listar(String nombre, String nombreCategoria);

    public Modificador obtenerModificador(Long idModificador);
    
    public void eliminar(Long id);
}
