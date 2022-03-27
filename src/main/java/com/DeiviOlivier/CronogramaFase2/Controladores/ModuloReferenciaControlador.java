/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Controladores;

import com.DeiviOlivier.CronogramaFase2.Dominios.Modulo;
import com.DeiviOlivier.CronogramaFase2.Dominios.ModuloReferencia;
import com.DeiviOlivier.CronogramaFase2.Dominios.Profesor;
import com.DeiviOlivier.CronogramaFase2.Dominios.Referencia;
import com.DeiviOlivier.CronogramaFase2.Servicios.IModuloReferenciaServicio;
import com.DeiviOlivier.CronogramaFase2.Servicios.IModuloServicio;
import com.DeiviOlivier.CronogramaFase2.Servicios.IProfesorServicio;
import com.DeiviOlivier.CronogramaFase2.Servicios.IReferenciaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author HP
 */
@Controller
public class ModuloReferenciaControlador {
    @Autowired
    private IModuloReferenciaServicio modServicio;
    @Autowired
    private IReferenciaServicio refServicio;
    @Autowired
    private IModuloServicio moduloServicio;
    @Autowired
    private IProfesorServicio profServ;
   
    
    @GetMapping("/modulosReferencia/{idReferencia}")
    public String inicio(Referencia referencia, Model model){
        List<ModuloReferencia> lista;
        List<Modulo> listaSeleccionar = null;
        referencia = refServicio.obtenerReferencia(referencia.getIdReferencia());
        if(referencia.getProgramaReferencia() != null)
        {
            listaSeleccionar = moduloServicio.listar(referencia.getProgramaReferencia().getIdPrograma());
        }
        else if (referencia.getModuloReferencia() != null)
        {
            listaSeleccionar = moduloServicio.listar(referencia);
        }
        lista = modServicio.listar(referencia);
        model.addAttribute("referencia", referencia);
        model.addAttribute("modSeleccionar", listaSeleccionar);
        model.addAttribute("modulosR", lista);
        return "listaModulosReferencia";
    }
    
    @GetMapping("/nuevoModuloReferencia")
    public String nuevoModuloRef(Referencia referencia, Modulo modulo,
            ModuloReferencia moduloReferencia, Model model){
        List<Profesor> lista = null;
        lista = profServ.listar();
        model.addAttribute("referencia", referencia);
        model.addAttribute("modulo", modulo);
        model.addAttribute("moduloReferencia", moduloReferencia);
        model.addAttribute("profesoresMod", lista);
        return "modulosReferencia";
    }
    
       
     @GetMapping("/editarModRef/{idModuloReferencia}")
    public String editar(ModuloReferencia moduloReferencia, RedirectAttributes red){
        String msg;
        moduloReferencia = modServicio.obtenerModuloReferencia(moduloReferencia.getIdModuloReferencia());
        if(moduloReferencia == null){
            msg="No se logró cargar el módulo de la referencia";
            red.addAttribute("idReferencia", moduloReferencia.getReferencia().getIdReferencia());
        return "redirect:/modulosReferencia";
            
        }
        red.addFlashAttribute("modificarModRef", "existe");
        red.addAttribute("idModulo", moduloReferencia.getModulo().getIdModulo());
         red.addAttribute("idReferencia", moduloReferencia.getReferencia().getIdReferencia());
        return "redirect:/nuevoModuloReferencia";

    }
    
    @GetMapping("/eliminarModRef/{idModuloReferencia}")
    public String eliminar(ModuloReferencia moduloReferencia, Referencia referencia, RedirectAttributes red){
        String msg;
        moduloReferencia = modServicio.obtenerModuloReferencia(moduloReferencia.getIdModuloReferencia());
        if(moduloReferencia != null){
         red.addFlashAttribute("moduloReferencia", moduloReferencia);
         red.addFlashAttribute("eliminarModRef","1");
         red.addAttribute("idModulo", moduloReferencia.getModulo().getIdModulo());
         red.addAttribute("idReferencia", moduloReferencia.getReferencia().getIdReferencia());
        return "redirect:/nuevoModuloReferencia";
        }
        msg = "No existe este módulo de la referencia";
        red.addFlashAttribute("msg", msg);
        red.addAttribute("idReferencia", referencia.getIdReferencia());
        return "redirect:/modulosReferencia";
       
    }
    
      @GetMapping("/guardarModRef")
    public String guardar(ModuloReferencia moduloReferencia, Referencia referencia, RedirectAttributes red){
     
         modServicio.guardar(moduloReferencia);
         red.addFlashAttribute("msg","Módulo de la referencia guardado");
         red.addAttribute("idReferencia", referencia.getIdReferencia());
        return "redirect:/modulosReferencia";
        
       
    }
    
    @GetMapping("/actualizarModRef")
    public String actualizar(ModuloReferencia moduloReferencia, Referencia referencia, RedirectAttributes red){
        String msg;
        moduloReferencia = modServicio.obtenerModuloReferencia(moduloReferencia.getIdModuloReferencia());
        if(moduloReferencia != null){
         red.addFlashAttribute("moduloReferencia", moduloReferencia);
         modServicio.guardar(moduloReferencia);
         
         red.addFlashAttribute("msg","Módulo de la referencia actualizada");
         red.addAttribute("idReferencia", referencia.getIdReferencia());
        return "redirect:/modulosReferencia";
        }
        msg = "No existe este módulo de la referencia";
        red.addFlashAttribute("msg", msg);
        red.addAttribute("idReferencia", referencia.getIdReferencia());
        return "redirect:/modulosReferencia";
       
    }
    
    @GetMapping("/borrarModRef/{idModuloReferencia}")
    public String borrar(ModuloReferencia moduloReferencia, Referencia referencia, RedirectAttributes red){
        String msg;
        moduloReferencia = modServicio.obtenerModuloReferencia(moduloReferencia.getIdModuloReferencia());
        if(moduloReferencia != null){
         modServicio.eliminar(moduloReferencia.getIdModuloReferencia());
         red.addFlashAttribute("msg", "Módulo de la referencia eliminado");
         red.addAttribute("idReferencia", moduloReferencia.getReferencia().getIdReferencia());
        return "redirect:/nuevoModuloReferencia";
        }
        msg = "No existe este módulo de la referencia";
        red.addFlashAttribute("msg", msg);
        red.addAttribute("idReferencia", referencia.getIdReferencia());
        return "redirect:/modulosReferencia";
       
    }
}
