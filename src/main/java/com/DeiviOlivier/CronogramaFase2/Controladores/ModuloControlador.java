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
    public String listar(Model model){
        List<Modulo> lista = servicioModulo.listar();
        model.addAttribute("modulos", lista);
        return "listarModulos";
    }
   
    @PostMapping("/filtrarModulos")
    public String filtrar(String txtTexto, Model model){
        List<Modulo> lista = servicioModulo.listar(txtTexto, txtTexto);
        model.addAttribute("modulos", lista);
        return "listarModulos";
    }
    
    @GetMapping("/nuevoModulo")
    public String nuevo(Modulo modulo){
        return "modulos";
    }
    
    @PostMapping("/guardarModulo")
    public String guardar(@Valid Modulo modulo, Errors er){
        
        if(er.hasErrors()){
            return "modulos";
        }
        
        servicioModulo.guardar(modulo);
        return "redirect:/modulos";
    }
    
    @GetMapping("/editarModulo/{idModulo}")
    public String editar(Modulo modulo, Model model){
        
        modulo = servicioModulo.obtenerModulo((modulo.getIdModulo()));
        if(modulo != null){
            model.addAttribute("modulos", modulo);
            return "modulos";
        }
        String msg="No se logró cargar el módulo";
        List<Modulo> lista = servicioModulo.listar();
        model.addAttribute("modulos", lista);
        model.addAttribute("msg", msg);
        return "listarModulos";
    }
}
