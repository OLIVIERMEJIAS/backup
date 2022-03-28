/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Servicios;

import com.DeiviOlivier.CronogramaFase2.Dominios.ModuloReferencia;
import com.DeiviOlivier.CronogramaFase2.Dominios.Referencia;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

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
    public HashMap verificarHorarioProfesor(int idProfesor,String respuesta,
            String msg,String diasEntrada, String horaEntradaInicio,
            Double horasDiariasEntrada,
            Date fechaIniEntrada, 
            Date fechaFinEntrada,int idModEntrada);
    
    public void calcular(long idReferencia,long idCentro);
    

}
