/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Controladores;

import com.DeiviOlivier.CronogramaFase2.Dominios.Modulo;
import com.DeiviOlivier.CronogramaFase2.Dominios.Programa;
import com.DeiviOlivier.CronogramaFase2.Dominios.Referencia;
import com.DeiviOlivier.CronogramaFase2.Servicios.IModuloReferenciaServicio;
import com.DeiviOlivier.CronogramaFase2.Servicios.IModuloServicio;
import com.DeiviOlivier.CronogramaFase2.Servicios.IProgramaServicio;
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
    @Autowired
    private IModuloServicio modServ;
    @Autowired
    private IProgramaServicio progServ;
    @Autowired
    private IModuloReferenciaServicio modRefServicio;
    @GetMapping("/nuevaReferencia")
    public String nuevaReferencia(Referencia referencia,Model model){
        List<Modulo> listMod = modServ.listar();
        List<Programa> listProg = progServ.listar();
        model.addAttribute("programasReferencia", listProg);
        model.addAttribute("modulosSeleccionar", listMod);
  
        model.addAttribute("selectPrograma", "1");

        return "referencia";
    }
      @GetMapping("/nuevaReferenciaMod")
    public String nuevaReferenciaMod(Referencia referencia,Model model){
        List<Modulo> listMod = modServ.listar();
        List<Programa> listProg = progServ.listar();
        model.addAttribute("programasReferencia", listProg);
        model.addAttribute("modulosSeleccionar", listMod);
  
        return "referencia";
    }
    
    @PostMapping("/guardarReferencias")
    public String guardar(Referencia referencia, Model model){
        referencia.setDiasReferencia("LMJ");
        referenciaServicio.guardar(referencia);
        model.addAttribute("msg", "Referencia agregada con éxito!");
        return "redirect:/listaReferencias";
    }
    
    @GetMapping("/referencias")
    public String nuevaReferencia(Model model){
        List<Referencia> lista = referenciaServicio.listar();
        model.addAttribute("referencias", lista);
        return "listaReferencias";
    }
    @PostMapping("/filtrarReferencias")
    public String filtrar(Referencia referencia,RedirectAttributes red){
        List<Referencia> lista;
        lista = referenciaServicio.filtrar(referencia.getReferencia());
        red.addFlashAttribute("referencias", lista);
        return "redirect:/referencias";
    }
    
     @GetMapping("/editarReferencia/{idReferencia}")
    public String editar(Referencia referencia, RedirectAttributes red){
        String msg;
        referencia = referenciaServicio.obtenerReferencia(referencia.getIdReferencia());
        if(referencia == null){
            msg="No se logró cargar la referencia";
            return "redirect:/referencias";
            
        }
        
    
        red.addFlashAttribute("referencia", referencia);
        return "redirect:/nuevaReferencia";
    }
    
    @GetMapping("/eliminarReferencia/{idReferencia}")
    public String eliminar(Referencia referencia, RedirectAttributes red){
        String msg;
        referencia = referenciaServicio.obtenerReferencia(referencia.getIdReferencia());
        if(referencia != null){
         red.addFlashAttribute("referencia", referencia);
         red.addFlashAttribute("accionEliminar","1");
        return "redirect:/nuevaReferencia";
        }
        msg = "No existe esta referencia";
        red.addFlashAttribute("msg", msg);
        return "redirect:/referencias";
       
    }
    
 
    
    @GetMapping("/borrarReferencia/{idReferencia}")
    public String borrarModulo(Referencia referencia, RedirectAttributes red) {
        String msg;
        referencia = referenciaServicio.obtenerReferencia(referencia.getIdReferencia());
        if (referencia!=null) {
            try {

                referenciaServicio.eliminar(referencia.getIdReferencia());
                modRefServicio.eliminarPorReferencia(referencia);
                msg = "Referencia borrada con éxito";
                 red.addFlashAttribute("msg", msg);
                return "redirect:/listaReferencias";
            } catch (Exception e) { 
                red.addFlashAttribute("msg","No un error borrando");
                
            }
        }
          msg = "No existe esta referencia";
                red.addFlashAttribute("msg", msg);
                return "redirect:/listaReferencias";
        
    }
    
    @GetMapping("/modalidad")
    public String modalidad(){
        return "modalidadReferencia";
    }
}

