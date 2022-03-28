/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.DAO;

import com.DeiviOlivier.CronogramaFase2.Dominios.ModuloReferencia;
import com.DeiviOlivier.CronogramaFase2.Dominios.Referencia;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author HP
 */
public interface IModuloReferenciaDAO extends JpaRepository<ModuloReferencia,Long>{
    public List<ModuloReferencia> findByReferencia(Referencia referencia);
    public void deleteAllByReferencia(Referencia referencia);
    @Override
    public ModuloReferencia save(ModuloReferencia moduloReferencia);
    @Procedure(name="sp_verificarHorario")
    public HashMap sp_verificarHorario_(
            @Param("ID_PROFESOR") int idProfesor,
            @Param("RESP") String respuesta,
            @Param("MSG") String msg,
            @Param("DIASENTRADA") String diasEntrada,
            @Param("HORAENTRADAINICIO") String horaEntradaInicio,
            @Param("HORAENTRADAFIN") String horaEntradaFin,
            @Param("FECHAINIENTRADA") Date fechaIniEntrada,
            @Param("FECHAFINENTRADA") Date fechaFinEntrada,
            @Param("IDMODENTRADA") int idModEntrada);
    
    
    @Procedure(procedureName = "CALCULAR")
    public void calcular(@Param("ID_REFERENCIA") long idReferencia, @Param("ID_CENTRO") long idCentro);
    
}
