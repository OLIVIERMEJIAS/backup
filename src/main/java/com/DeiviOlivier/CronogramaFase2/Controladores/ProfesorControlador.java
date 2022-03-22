/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Controladores;

import com.DeiviOlivier.CronogramaFase2.Dominios.Profesor;
import com.DeiviOlivier.CronogramaFase2.Servicios.IProfesorServicio;
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
public class ProfesorControlador {
    @Autowired
    private IProfesorServicio servicioProfesor;
    
    @GetMapping("/profesores")
    public String listar(Model model){
        List<Profesor> lista = servicioProfesor.listar();
        model.addAttribute("profesores", lista);
        return "listarProfesores";
    }
   
    @PostMapping("/filtrarProfesores")
    public String filtrar(String txtTexto, Model model){
        List<Profesor> lista = servicioProfesor.listar(txtTexto, txtTexto,txtTexto);
        model.addAttribute("profesores", lista);
        return "listarProfesores";
    }
    
    @GetMapping("/nuevoProfesor")
    public String nuevo(Profesor profesor){
        return "profesor";
    }
    
    @PostMapping("/guardarProfesores")
    public String guardar(@Valid Profesor profesor, Errors er){
        
        if(er.hasErrors()){
            return "profesor";
        }
        
        servicioProfesor.guardar(profesor);
        return "redirect:/profesores";
    }
    
    @GetMapping("/editarProfesor/{idProfesor}")
    public String editar(Profesor profesor, Model model, RedirectAttributes redirAtt){
        profesor = servicioProfesor.obtenerProfesor(profesor.getIdProfesor());
        if(profesor != null){
            model.addAttribute("profesor", profesor);
            return "profesor"; 
        }else{
            String msg="Imposible cargar el profesor";
            redirAtt.addFlashAttribute("msg", msg);
            return "redirect:/profesores";
        }
        
    }
    
    @GetMapping("/eliminarProfesor")
    public String eliminar(Profesor profesor, Model model){
        
        String msg="";
        
        if (profesor!=null) {
            try {
                servicioProfesor.eliminar(profesor.getIdProfesor());
                msg="Profesor Eliminado!";
                model.addAttribute("msg",msg);
            } catch (Exception e) { model.addAttribute("msg","Hubo un error");
            }
        }
        //Esto no se gace
        List<Profesor> lista = servicioProfesor.listar();
        model.addAttribute("profesor", lista);
        //Hasta Aquí
        return "listarProfesores";
        
        //TODO: PONERLE LOS REDIRECT ATRIBUTTES
    }
    
}
