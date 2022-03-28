/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.Dominios.Modulo;
import com.DeiviOlivier.CronogramaFase2.Dominios.Programa;
import com.DeiviOlivier.CronogramaFase2.Dominios.Referencia;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IReferenciaServicio {
    public void eliminar(Long id);
    public void guardar(Referencia referencia);
    public Referencia obtenerReferencia(Long id);
    public List<Referencia> listar();
    public List<Referencia> filtrar(String codigo);
    public int asociarPrograma(Long idPrograma,Long idReferencia);
    public int asociarModulo(Long idPrograma,Long idReferencia);
}
