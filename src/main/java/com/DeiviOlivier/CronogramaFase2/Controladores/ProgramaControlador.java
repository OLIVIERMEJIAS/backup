/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Controladores;

import com.DeiviOlivier.CronogramaFase2.Dominios.Programa;
import com.DeiviOlivier.CronogramaFase2.Servicios.IProgramaServicio;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@Slf4j
public class ProgramaControlador {
    @Autowired
    private IProgramaServicio servicioPrograma;
    
    @GetMapping("/programas")
    public String listar(Model model){
        List<Programa> lista = servicioPrograma.listar();
        model.addAttribute("programas", lista);
        return "listarProgramas";
    }
   
    @PostMapping("/filtrarProgramas")
    public String filtrar(String txtTexto, Model model){
        List<Programa> lista = servicioPrograma.listar(txtTexto, txtTexto);
        model.addAttribute("programas", lista);
        return "listarProgramas";
    }
    
    @GetMapping("/nuevoPrograma")
    public String nuevo(Programa programa){
        return "programa";
    }
    
    @PostMapping("/guardarPrograma")
    public String guardar(@Valid Programa programa, Errors er){
        
        if(er.hasErrors()){
            return "programa";
        }
        
        servicioPrograma.guardar(programa);
        return "redirect:/programas";
    }
    
    @GetMapping("/editarPrograma/{idPrograma}")
    public String editar(Programa programa, Model model,RedirectAttributes redirAtt){
        
        programa = servicioPrograma.obtenerPrograma(programa.getIdPrograma());
        
        if (programa != null) {
            redirAtt.addFlashAttribute("programa", programa);
            return "redirect:/nuevoPrograma";
        } else {
            String editar = "Imposible cargar el programa";
            redirAtt.addFlashAttribute("editar", editar);
            return "redirect:/listarProgramas";
        }
    }
    
    @GetMapping("/eliminarPrograma")
    public String eliminar(Programa programa, Model model,RedirectAttributes redirAtt){
        
        programa = servicioPrograma.obtenerPrograma(programa.getIdPrograma());

        if (programa != null) {
            redirAtt.addFlashAttribute("programa", programa);
            String eliminar = "1";
            redirAtt.addFlashAttribute("eliminar", eliminar);
            redirAtt.addFlashAttribute("editar", "2");
            return "redirect:/nuevoPrograma";
        } else {
            String eliminar = "Imposible cargar el programa";
            redirAtt.addFlashAttribute("eliminar", eliminar);
            return "redirect:/listarProgramas";
        }
    }
    
    @GetMapping("/borrarPrograma")
    public String borrarPrograma(Programa programa, Model model,RedirectAttributes redirAtt) {

        if (programa!=null) {
            try {
                servicioPrograma.eliminar(programa.getIdPrograma());
                redirAtt.addFlashAttribute("msg","Eliminado con éxito");
                return "redirect:/programas";
            } catch (Exception e) { 
                redirAtt.addFlashAttribute("msg","No se puede eliminar un programa vinculado actualmente");
                
            }
        }
        return "redirect:/programas";
    }
}
