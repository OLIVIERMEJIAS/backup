/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.DAO;
import com.DeiviOlivier.CronogramaFase2.Dominios.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
/**
 *
 * @author HP
 */
public interface IMensajeDAO extends JpaRepository<Mensaje, Long>{
    @Modifying
    @Query(value="Update Mensajes Set RESPUESTA_MENSAJE = ?1 Where ID_MENSAJE = ?2",
            nativeQuery = true)
    public void actualizarRespuesta( String respuesta, Long idMensaje);
}
