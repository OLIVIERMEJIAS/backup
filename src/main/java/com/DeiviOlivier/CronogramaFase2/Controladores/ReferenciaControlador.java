/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Controladores;

import com.DeiviOlivier.CronogramaFase2.Dominios.Referencia;
import com.DeiviOlivier.CronogramaFase2.Servicios.IReferenciaServicio;
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
public class ReferenciaControlador {
    @Autowired
    private IReferenciaServicio referenciaServicio;
    @GetMapping("/nuevaReferencia")
    public String nuevaReferencia(Referencia referencia){
        return "referencia";
    }
    
    @PostMapping("/guardarReferencias")
    public String guardar(Referencia referencia, RedirectAttributes red){
        return "listaReferencias";
    }
    
    @GetMapping("/referencias")
    public String nuevaReferencia(Model model){
        List<Referencia> lista;
        //model.addAttribute("referencias", lista);
        return "listaReferencias";
    }
    @PostMapping("/filtrarReferencias")
    public String filtrar(Referencia referencia){
        List<Referencia> lista;
        lista = referenciaServicio.filtrar(referencia.getReferencia());
        //model.addAttribute("referencias", lista);
        return "listaReferencias";
    }
    
     @GetMapping("/editarReferencia/{idReferencia}")
    public String editar(Referencia referencia, Model model,RedirectAttributes red){
        String msg;
        referencia = referenciaServicio.obtenerReferencia(referencia.getIdReferencia());
        if(referencia == null){
            model.addAttribute("referencia", referencia);
            msg="No se logró cargar la referencia";
            return "redirect:/listaReferencias";
            
        }
        referenciaServicio.guardar(referencia);
        msg="Referencia actualizada con éxito";
        red.addFlashAttribute("msg", msg);
        return "redirect:/listaClientes";
    }
    
    @GetMapping("/eliminarReferencia")
    public String eliminar(Referencia referencia, RedirectAttributes red){
        String msg;
        referencia = referenciaServicio.obtenerReferencia(referencia.getIdReferencia());
        if(referencia != null){
        referenciaServicio.eliminar(referencia.getIdReferencia());
        //borrar modulos referencias
        msg = "Referencia borrada con éxito";
        }
        msg = "No existe esta referencia";
        red.addFlashAttribute("msg", msg);
        return "redirect:/listaReferencias";
       
    }
}
