/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.Dominios.ModuloReferencia;
import com.DeiviOlivier.CronogramaFase2.Dominios.Referencia;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IModuloReferenciaServicio {
    public void eliminar(Long id);
    public void guardar(ModuloReferencia moduloReferencia);
    public ModuloReferencia obtenerModuloReferencia(Long id);
    public List<ModuloReferencia> listar(Referencia referencia);
    public void eliminarPorReferencia(Referencia referencia);
}
