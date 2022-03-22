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
    public String editar(Programa programa, Model model){
        
        programa = servicioPrograma.obtenerPrograma((programa.getIdPrograma()));
        if(programa != null){
            model.addAttribute("programa", programa);
            return "programa";
        }
        String msg="No se logró cargar el programa";
        List<Programa> lista = servicioPrograma.listar();
        model.addAttribute("programas", lista);
        model.addAttribute("msg", msg);
        return "listarProgramas";
    }
    
    @GetMapping("/eliminarPrograma")
    public String eliminar(Programa programa, Model model){
        
        String msg="";
        programa = servicioPrograma.obtenerPrograma((programa.getIdPrograma()));
        
        if (programa!=null) {
            try {
                servicioPrograma.eliminar(programa.getIdPrograma());
                msg="Programa Eliminado!";
                model.addAttribute("msg",msg);
            } catch (Exception e) { model.addAttribute("msg","Hubo un error al eliminar");
            }
        }
        //Esto no se gace
        List<Programa> lista = servicioPrograma.listar();
        model.addAttribute("programas", lista);
        //Hasta Aquí
        return "listarProgramas";
        
        //TODO: PONERLE LOS REDIRECT ATRIBUTTES
    }
}
