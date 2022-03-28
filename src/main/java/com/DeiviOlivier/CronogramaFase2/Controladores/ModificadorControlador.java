
package com.DeiviOlivier.CronogramaFase2.Controladores;

import com.DeiviOlivier.CronogramaFase2.Dominios.Modificador;
import com.DeiviOlivier.CronogramaFase2.Dominios.Profesor;
import com.DeiviOlivier.CronogramaFase2.Servicios.IModificadorServicio;
import com.DeiviOlivier.CronogramaFase2.Servicios.IProfesorServicio;
import java.sql.Date;
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
public class ModificadorControlador {
    @Autowired
    private IModificadorServicio servicioModificador;

    @Autowired
    private IProfesorServicio servicioProfesor;
    
    @GetMapping("/modificadores")
    public String listar(Model model) {
        List<Modificador> lista = servicioModificador.listar();
        model.addAttribute("modificadores", lista);
        return "listarModificadores";
    }

    @PostMapping("/filtrarModificadores")
    public String filtrar(String txtTexto, Model model) {
        List<Modificador> lista = servicioModificador.listar(txtTexto, txtTexto);
        model.addAttribute("modificadores", lista);
        return "listarModificadores";
    }

    @GetMapping("/nuevoModificador")
    public String nuevo(Modificador modificador, Model model) {
        List<Profesor> list = servicioProfesor.listar();
        model.addAttribute("profesores", list);
        return "modificador";
    }

    @PostMapping("/guardarModificador")
    public String guardar(@Valid Modificador modificador, Errors er,RedirectAttributes red) {
        
        Date inicio= modificador.getInicioModificador();
        Date fin= modificador.getFinalModificador();
        
        if (inicio.after(fin)) {
            red.addFlashAttribute("msg","La fecha final debe ser después o el mismo día de la fecha inicial");
            red.addFlashAttribute("modificador",modificador);
            return "redirect:/nuevoModificador";
        }
        if (er.hasErrors()) {
            red.addFlashAttribute("msg","No se pudo guardar");
            return "modificador";
        }

        servicioModificador.guardar(modificador);
        red.addFlashAttribute("msg","Guardado con éxito");
        return "redirect:/modificadores";
    }

    @GetMapping("/editarModificador/{idModificador}")
    public String editar(Modificador modificador, Model model, RedirectAttributes redirAtt) {
        modificador = servicioModificador.obtenerModificador(modificador.getIdModificador());

        if (modificador != null) {
            redirAtt.addFlashAttribute("modificador", modificador);
            return "redirect:/nuevoModificador";
        } else {
            String editar = "Imposible cargar el asunto";
            redirAtt.addFlashAttribute("editar", editar);
            return "redirect:/listarModificadores";
        }

    }

    @GetMapping("/eliminarModificador")
    public String eliminar(Modificador modificador, Model model, RedirectAttributes redirAtt) {

        modificador = servicioModificador.obtenerModificador(modificador.getIdModificador());

        if (modificador != null) {
            redirAtt.addFlashAttribute("modificador", modificador);
            String eliminar = "1";
            redirAtt.addFlashAttribute("eliminar", eliminar);
            redirAtt.addFlashAttribute("editar", "2");
            return "redirect:/nuevoModificador";
        } else {
            String eliminar = "Imposible cargar el asunto";
            redirAtt.addFlashAttribute("eliminar", eliminar);
            return "redirect:/listarModificadores";
        }

    }
    
    @GetMapping("/borrarModificador")
    public String borrarModificador(Modificador modificador, Model model,RedirectAttributes redirAtt) {

        if (modificador!=null) {
            try {
                servicioModificador.eliminar(modificador.getIdModificador());
                redirAtt.addFlashAttribute("msg","Eliminado con éxito");
                return "redirect:/modificadores";
            } catch (Exception e) { 
                redirAtt.addFlashAttribute("msg","No se puede eliminar un asunto vinculado actualmente");
                
            }
        }
        return "redirect:/modificadores";
    }
}
