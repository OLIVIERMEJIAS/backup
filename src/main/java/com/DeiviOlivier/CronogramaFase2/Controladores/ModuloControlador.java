/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Controladores;

import com.DeiviOlivier.CronogramaFase2.Dominios.Modulo;
import com.DeiviOlivier.CronogramaFase2.Servicios.IModuloServicio;
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

/**
 *
 * @author HP
 */
@Controller
@Slf4j
public class ModuloControlador {

    @Autowired
    private IModuloServicio servicioModulo;

    @GetMapping("/modulos")
    public String listar(Model model) {
        List<Modulo> lista = servicioModulo.listar();
        model.addAttribute("modulos", lista);
        return "listarModulos";
    }

    @PostMapping("/filtrarModulos")
    public String filtrar(String txtTexto, Model model) {
        List<Modulo> lista = servicioModulo.listar(txtTexto, txtTexto);
        model.addAttribute("modulos", lista);
        return "listarModulos";
    }

    @GetMapping("/nuevoModulo")
    public String nuevo(Modulo modulo, Model model) {
        List<Modulo> lista = servicioModulo.listar();
        model.addAttribute("modulos", lista);
        return "modulo";
    }

    @PostMapping("/guardarModulo")
    public String guardar(@Valid Modulo modulo, Errors er) {

        if (er.hasErrors()) {
            return "modulo";
        }

        servicioModulo.guardar(modulo);
        return "redirect:/modulos";
    }

    @GetMapping("/editarModulo/{idModulo}")
    public String editar(Modulo modulo, Model model, RedirectAttributes redirAtt) {
        modulo = servicioModulo.obtenerModulo(modulo.getIdModulo());

        if (modulo != null) {
            redirAtt.addFlashAttribute("modulo", modulo);
            return "redirect:/nuevoModulo";
        } else {
            String editar = "Imposible cargar el modulo";
            redirAtt.addFlashAttribute("editar", editar);
            return "redirect:/listarModulos";
        }

    }

    @GetMapping("/eliminarModulo")
    public String eliminar(Modulo modulo, Model model, RedirectAttributes redirAtt) {

        modulo = servicioModulo.obtenerModulo(modulo.getIdModulo());

        if (modulo != null) {
            redirAtt.addFlashAttribute("modulo", modulo);
            String eliminar = "1";
            redirAtt.addFlashAttribute("eliminar", eliminar);
            redirAtt.addFlashAttribute("editar", "2");
            return "redirect:/nuevoModulo";
        } else {
            String eliminar = "Imposible cargar el modulo";
            redirAtt.addFlashAttribute("eliminar", eliminar);
            return "redirect:/listarModulos";
        }

    }
    
    @GetMapping("/borrarModulo")
    public String borrarModulo(Modulo modulo, Model model,RedirectAttributes redirAtt) {

        if (modulo!=null) {
            try {
                servicioModulo.eliminar(modulo.getIdModulo());
                redirAtt.addFlashAttribute("msg","Eliminado con éxito");
                return "redirect:/modulos";
            } catch (Exception e) { 
                redirAtt.addFlashAttribute("msg","No se puede eliminar un módulo vinculado actualmente");
                
            }
        }
        return "redirect:/modulos";
    }
}
