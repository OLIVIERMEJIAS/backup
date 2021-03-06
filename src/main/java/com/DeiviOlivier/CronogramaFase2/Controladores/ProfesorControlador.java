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
    
    @PostMapping("/guardarProfesor")
    public String guardar(@Valid Profesor profesor, Errors er,Model model,RedirectAttributes redAtr){
        
        if (servicioProfesor.existeCedula(profesor.getCedulaProfesor())==true) {
            
            redAtr.addFlashAttribute("msg","Esta cédula ya está en uso");
            redAtr.addFlashAttribute("profesor",profesor);
            return "redirect:/nuevoProfesor";
        }
        if(er.hasErrors()){
            redAtr.addFlashAttribute("msg","No se pudo guardar");
            return "profesor";
        }
        if (servicioProfesor.existeEmail(profesor.getCorreoProfesor())==true) {
            redAtr.addFlashAttribute("msg","Este correo  ya está en uso");
            redAtr.addFlashAttribute("profesor",profesor);
            return "redirect:/nuevoProfesor";
        }
        
        servicioProfesor.guardar(profesor);
        redAtr.addFlashAttribute("msg","Guardado con éxito");
        return "redirect:/profesores";
    }
    
    @GetMapping("/editarProfesor/{idProfesor}")
    public String editar(Profesor profesor, Model model, RedirectAttributes redirAtt){
        profesor = servicioProfesor.obtenerProfesor(profesor.getIdProfesor());
        
        if (profesor != null) {
            redirAtt.addFlashAttribute("profesor", profesor);
            return "redirect:/nuevoProfesor";
        } else {
            String editar = "Imposible cargar el profesor";
            redirAtt.addFlashAttribute("editar", editar);
            return "redirect:/listarProfesores";
        }
        
    }
    
    @GetMapping("/eliminarProfesor")
    public String eliminar(Profesor profesor, Model model,RedirectAttributes redirAtt){
        
        profesor = servicioProfesor.obtenerProfesor(profesor.getIdProfesor());

        if (profesor != null) {
            redirAtt.addFlashAttribute("profesor", profesor);
            String eliminar = "1";
            redirAtt.addFlashAttribute("eliminar", eliminar);
            redirAtt.addFlashAttribute("editar", "2");
            return "redirect:/nuevoProfesor";
        } else {
            String eliminar = "Imposible cargar el profesor";
            redirAtt.addFlashAttribute("eliminar", eliminar);
            return "redirect:/listarProfesores";
        }
    }
    
    @GetMapping("/borrarProfesor")
    public String borrarProfesor(Profesor profesor, Model model,RedirectAttributes redirAtt) {

        if (profesor!=null) {
            try {
                servicioProfesor.eliminar(profesor.getIdProfesor());
                redirAtt.addFlashAttribute("msg","Eliminado con éxito");
                return "redirect:/profesores";
            } catch (Exception e) { 
                redirAtt.addFlashAttribute("msg","No se puede eliminar un profesor vinculado actualmente");
                
            }
        }
        return "redirect:/profesores";
    }
    
    @GetMapping("/modificador")
    public String modificadores(Model model){
        return "modificador";
    }
    @GetMapping("/contrasenaProfesor")
    public String cambioAdministrador(Profesor Profesor){
        return "cambioContrasenaProfesor";
    }
    @GetMapping("/cambioAdministrador")
    public String cambioContraseña(Profesor profesor,RedirectAttributes red){
        Profesor aux = null;
        aux = servicioProfesor.obtenerProfesor(profesor.getIdProfesor());
        if(aux != null){
            if(profesor.getContrasenaProfesor().equals(profesor.getContrasenaRepetida())){
                servicioProfesor.guardar(profesor);
            }
            else{
                red.addFlashAttribute("msg", "La contraseña no concuerda con la repetición de la esta!");
                red.addFlashAttribute("profesor", profesor);
                return "redirect:/contrasenaProfesor";
            }
        }
        else{
            red.addFlashAttribute("msg", "Este profesor ya no existe!");
            return "redirect:/";
        }
        red.addFlashAttribute("msg", "Contraseña actualizada con éxito");
        return "redirect:/";
    }
}
