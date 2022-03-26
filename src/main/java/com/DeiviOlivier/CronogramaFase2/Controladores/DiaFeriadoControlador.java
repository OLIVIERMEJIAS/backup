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

    @GetMapping("/dias")
    public String listar(Model model) {
        List<DiaFeriado> lista = servicioDia.listar();
        model.addAttribute("dias", lista);
        return "listarDias";
    }

    @PostMapping("/filtrarDias")
    public String filtrar(String txtTexto, Model model) {
        List<DiaFeriado> lista = servicioDia.listar(txtTexto);
        model.addAttribute("dias", lista);
        return "listarDias";
    }

    @GetMapping("/nuevoDia")
    public String nuevo(DiaFeriado dia) {
        return "dia";
    }

    @PostMapping("/guardarDia")
    public String guardar(@Valid DiaFeriado dia, Errors er) {

        if (er.hasErrors()) {
            return "dia";
        }

        servicioDia.guardar(dia);
        return "redirect:/dias";
    }

    @GetMapping("/editarDia/{idDiaFeriado}")
    public String editar(DiaFeriado dia, Model model, RedirectAttributes redirAtt) {
        dia = servicioDia.obtenerDia(dia.getIdDiaFeriado());

        if (dia != null) {
            redirAtt.addFlashAttribute("dia", dia);
            return "redirect:/nuevoDia";
        } else {
            String editar = "Imposible cargar el día";
            redirAtt.addFlashAttribute("editar", editar);
            return "redirect:/listarDias";
        }

    }

    @GetMapping("/eliminarDia")
    public String eliminar(DiaFeriado dia, Model model, RedirectAttributes redirAtt) {

        dia = servicioDia.obtenerDia(dia.getIdDiaFeriado());

        if (dia != null) {
            redirAtt.addFlashAttribute("dia", dia);
            String eliminar = "1";
            redirAtt.addFlashAttribute("eliminar", eliminar);
            redirAtt.addFlashAttribute("editar", "2");
            return "redirect:/nuevoDia";
        } else {
            String eliminar = "Imposible cargar el dia";
            redirAtt.addFlashAttribute("eliminar", eliminar);
            return "redirect:/listarDias";
        }

    }
    
    @GetMapping("/borrarDia")
    public String borrarDia(DiaFeriado dia, Model model,RedirectAttributes redirAtt) {

        if (dia!=null) {
            try {
                servicioDia.eliminar(dia.getIdDiaFeriado());
                redirAtt.addFlashAttribute("msg","Eliminado con éxito");
                return "redirect:/dias";
            } catch (Exception e) { 
                redirAtt.addFlashAttribute("msg","No se puede eliminar un día vinculado actualmente");
                
            }
        }
        return "redirect:/dias";
    }
}
