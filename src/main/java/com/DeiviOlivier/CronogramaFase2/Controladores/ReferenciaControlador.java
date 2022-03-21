/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Controladores;

import com.DeiviOlivier.CronogramaFase2.Dominios.Referencia;
import java.util.List;
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
    public String filtrar(Model model){
        List<Referencia> lista;
        //model.addAttribute("referencias", lista);
        return "listaReferencias";
    }
}
