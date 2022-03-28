/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Controladores;

import com.DeiviOlivier.CronogramaFase2.Dominios.DiaFeriado;
import com.DeiviOlivier.CronogramaFase2.Servicios.IDiaFeriadoServicio;
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

public class DiaFeriadoControlador {
    @Autowired
    private IDiaFeriadoServicio servicioDia;

    @GetMapping("/diasFeriados")
    public String listar(Model model) {
        List<DiaFeriado> lista = servicioDia.listar();
        model.addAttribute("diasFeriados", lista);
        return "listarDiasFeriados";
    }

    @GetMapping("/nuevoDiaFeriado")
    public String nuevo(DiaFeriado diaFeriado, Model model) {
        List<DiaFeriado> lista = servicioDia.listar();
        model.addAttribute("diasFeriados", lista);
        return "diaFeriado";
    }

    @PostMapping("/guardarDiaFeriado")
    public String guardar(@Valid DiaFeriado diaFeriado, Errors er) {

        if (er.hasErrors()) {
            return "diaFeriado";
        }

        servicioDia.guardar(diaFeriado);
        return "redirect:/diasFeriados";
    }

    @GetMapping("/editarDiaFeriado/{idDiaFeriado}")
    public String editar(DiaFeriado diaFeriado, Model model, RedirectAttributes redirAtt) {
        diaFeriado = servicioDia.obtenerDia(diaFeriado.getIdDiaFeriado());

        if (diaFeriado != null) {
            redirAtt.addFlashAttribute("diaFeriado", diaFeriado);
            return "redirect:/nuevoDiaFeriado";
        } else {
            String editar = "Imposible cargar el día";
            redirAtt.addFlashAttribute("editar", editar);
            return "redirect:/listarDiasFeriados";
        }

    }

    @GetMapping("/eliminarDiaFeriado")
    public String eliminar(DiaFeriado diaFeriado, Model model, RedirectAttributes redirAtt) {

        diaFeriado = servicioDia.obtenerDia(diaFeriado.getIdDiaFeriado());

        if (diaFeriado != null) {
            redirAtt.addFlashAttribute("diaFeriado", diaFeriado);
            String eliminar = "1";
            redirAtt.addFlashAttribute("eliminar", eliminar);
            redirAtt.addFlashAttribute("editar", "2");
            return "redirect:/nuevoDiaFeriado";
        } else {
            String eliminar = "Imposible cargar el día";
            redirAtt.addFlashAttribute("eliminar", eliminar);
            return "redirect:/listarDiasFeriados";
        }

    }
    
    @GetMapping("/borrarDiaFeriado")
    public String borrarDiaFeriado(DiaFeriado diaFeriado, Model model,RedirectAttributes redirAtt) {

        if (diaFeriado!=null) {
            try {
                servicioDia.eliminar(diaFeriado.getIdDiaFeriado());
                redirAtt.addFlashAttribute("msg","Eliminado con éxito");
                return "redirect:/diasFeriados";
            } catch (Exception e) { 
                redirAtt.addFlashAttribute("msg","No se puede eliminar un día vinculado actualmente");
                
            }
        }
        return "redirect:/diasFeriados";
    }
}
