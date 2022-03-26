/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Controladores;

import com.DeiviOlivier.CronogramaFase2.Dominios.Mensaje;
import com.DeiviOlivier.CronogramaFase2.Servicios.IMensajeServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author HP
 */
@Controller
public class MensajeControlador {
    @Autowired
    private IMensajeServicio mensajServ;
    @GetMapping("/mensajesAdmin")
    public String listar(Model model){
        List<Mensaje> mensajes;
        mensajes = mensajServ.listar();
        model.addAttribute("mensajes", mensajes);
        return "listaMensajes";
    }
    
    @GetMapping("/respuesta/{idMensaje}")
    public String responder(Mensaje mensaje,Model model){
        model.addAttribute("mensaje", mensaje);
        return "respuestaMensaje";
    }
    
    @PostMapping("/enviarRespuesta/{idMensaje}")
    public String actualizarRespuesta(Mensaje mensaje,RedirectAttributes red){
        String msg ="";
        mensaje = mensajServ.obtenerMensaje(mensaje.getIdMensaje());
        if(mensaje != null){
            mensajServ.actualizarRespuesta(mensaje.getRespuestaMensaje(),mensaje.getIdMensaje());
            msg = "Respuesta ingresado con éxito!";
            red.addFlashAttribute("msg", msg);
            return "redirect:/mensajesAdmin";
        }
        msg="No existe este mensaje";
        red.addFlashAttribute("msg", msg);
        return "redirect:/mensajesAdmin";
    }
    
       @GetMapping("/eliminarMensaje/{idMensaje}")
    public String eliminar(Mensaje mensaje,RedirectAttributes red){
        String msg ="";
        mensaje = mensajServ.obtenerMensaje(mensaje.getIdMensaje());
        if(mensaje != null){
            mensajServ.eliminar(mensaje.getIdMensaje());
            msg = "Mensaje eliminado con éxito!";
            red.addFlashAttribute("msg", msg);
            return "redirect:/mensajesAdmin";
        }
        msg="No existe este mensaje";
        red.addFlashAttribute("msg", msg);
        return "redirect:/mensajesAdmin";
    }


}
