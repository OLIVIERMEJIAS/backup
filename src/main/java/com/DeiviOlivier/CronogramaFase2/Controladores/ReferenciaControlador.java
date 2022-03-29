/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Controladores;

import com.DeiviOlivier.CronogramaFase2.Dominios.Modulo;
import com.DeiviOlivier.CronogramaFase2.Dominios.ModuloReferencia;
import com.DeiviOlivier.CronogramaFase2.Dominios.Profesor;
import com.DeiviOlivier.CronogramaFase2.Dominios.Programa;
import com.DeiviOlivier.CronogramaFase2.Dominios.Referencia;
import com.DeiviOlivier.CronogramaFase2.Servicios.IModuloReferenciaServicio;
import com.DeiviOlivier.CronogramaFase2.Servicios.IModuloServicio;
import com.DeiviOlivier.CronogramaFase2.Servicios.IProgramaServicio;
import com.DeiviOlivier.CronogramaFase2.Servicios.IReferenciaServicio;
import java.util.List;
import javax.validation.Valid;
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
public class ReferenciaControlador {

    @Autowired
    private IReferenciaServicio referenciaServicio;
    @Autowired
    private IModuloServicio modServ;
    @Autowired
    private IProgramaServicio progServ;
    @Autowired
    private IModuloReferenciaServicio modRefServicio;

    @GetMapping("/modalidad")
    public String modalidad() {
        return "modalidadReferencia";
    }

    @GetMapping("/nuevaReferencia")
    public String nuevaReferencia(Referencia referencia, Model model) {
        List<Modulo> listMod = modServ.listar();
        List<Programa> listProg = progServ.listar();
        model.addAttribute("referencia", referencia);
        return "referencia";
    }

    @PostMapping("/guardarReferencia")
    public String guardar(@Valid Referencia referencia, RedirectAttributes red, Errors e) {
        if (e.hasErrors()) {
            red.addAttribute("referencia", referencia);
            return "redirect:/nuevaReferencia";
        }
        referenciaServicio.guardar(referencia);
        red.addFlashAttribute("msg", "Referencia agregada con éxito!");
        return "redirect:/referencias";
    }

    @GetMapping("/referencias")
    public String listarReferenciaS(Model model) {
        List<Referencia> lista = referenciaServicio.listar();
        model.addAttribute("referencias", lista);
        return "listaReferencias";
    }

    @PostMapping("/filtrarReferencias")
    public String filtrar(Referencia referencia, RedirectAttributes red) {
        List<Referencia> lista;
        lista = referenciaServicio.filtrar(referencia.getCodigo());
        red.addFlashAttribute("referencias", lista);
        return "redirect:/referencias";
    }

    @GetMapping("/editarReferencia/{idReferencia}")
    public String editar(Referencia referencia, RedirectAttributes red) {
        String msg;
        referencia = referenciaServicio.obtenerReferencia(referencia.getIdReferencia());
        if (referencia == null) {
            msg = "No se logró cargar la referencia";
            return "redirect:/referencias";

        }

        red.addFlashAttribute("referencia", referencia);
        return "redirect:/nuevaReferencia";
    }

    @GetMapping("/eliminarReferencia/{idReferencia}")
    public String eliminar(Referencia referencia, RedirectAttributes red) {
        String msg;
        referencia = referenciaServicio.obtenerReferencia(referencia.getIdReferencia());
        if (referencia != null) {
            red.addFlashAttribute("referencia", referencia);
            red.addFlashAttribute("accionEliminar", "1");
            return "redirect:/nuevaReferencia";
        }
        msg = "No existe esta referencia";
        red.addFlashAttribute("msg", msg);
        return "redirect:/referencias";

    }

    @GetMapping("/borrarReferencia/{idReferencia}")
    public String borrarModulo(Referencia referencia, RedirectAttributes red) {
        String msg;
        referencia = referenciaServicio.obtenerReferencia(referencia.getIdReferencia());
        if (referencia != null) {
            try {

                referenciaServicio.eliminar(referencia.getIdReferencia());
                modRefServicio.eliminarPorReferencia(referencia);
                msg = "Referencia borrada con éxito";
                red.addFlashAttribute("msg", msg);
                return "redirect:/referencias";
            } catch (Exception e) {
                red.addFlashAttribute("msg", "Hubo un error borrando.");

            }
        }
        msg = "No existe esta referencia";
        red.addFlashAttribute("msg", msg);
        return "redirect:/referencias";

    }

    @GetMapping("/modalidades/{idReferencia}")
    public String elegirModalidad(Referencia referencia, Model model) {
        model.addAttribute("referencia", referencia);
        return "modalidad.html";
    }

    @GetMapping("/asociarProgramas/{idReferencia}")
    public String vincularProgramas(Referencia referencia, Programa programa, Model model) {
        List<Programa> lista = null;
        lista = progServ.listar();
        model.addAttribute("programasReferencia", lista);
        model.addAttribute("referencia", referencia);
        return "asociarPrograma";
    }

    @GetMapping("/asociarModulos/{idReferencia}")
    public String vincularModulos(Referencia referencia, Modulo modulo, Model model) {
        List<Modulo> lista = null;
        lista = modServ.listar();
        model.addAttribute("modulosSeleccionar", lista);
        model.addAttribute("referencia", referencia);
        model.addAttribute("modulo", modulo);
        return "asociarModulo";
    }

    @PostMapping("/programaAsociar/{idReferencia}")
    public String cargarPrograma(Referencia referencia, Programa programa, RedirectAttributes red) {
        referencia = referenciaServicio.obtenerReferencia(referencia.getIdReferencia());
         if(referencia.getModuloReferencia() != null){
            red.addFlashAttribute("msg", "No se puede asociar un programa a la modalidad de la referencia"
                    + ", puesto que ya existe un módulo asociado!");
            return "redirect:/referencias";
        }
        else{
        programa = progServ.obtenerPrograma(programa.getIdPrograma());
        referencia.setProgramaReferencia(programa);
        referenciaServicio.guardar(referencia);
        red.addFlashAttribute("msg", "Programa asociado a la referencia.");
        return "redirect:/referencias";
         }
    }

    @PostMapping("/moduloAsociar/{idReferencia}")
    public String cargarModulo(Referencia referencia, Modulo modulo, RedirectAttributes red) {
        referencia = referenciaServicio.obtenerReferencia(referencia.getIdReferencia());
        if(referencia.getProgramaReferencia() != null){
            red.addFlashAttribute("msg", "No se puede asociar un módulo a la modalidad de la referencia"
                    + ", puesto que ya existe un programa asociado!");
            return "redirect:/referencias";
        }
        else{
        modulo = modServ.obtenerModulo(modulo.getIdModulo());
        referencia.setModuloReferencia(modulo);
        referenciaServicio.guardar(referencia);
        red.addFlashAttribute("msg", "Módulo asociado a la referencia");
        return "redirect:/referencias";
        }
    }
    
     @GetMapping("/cronoAdministrador")
    public String administradorCronogramas(Model model)
    {
        List<Referencia> lista = referenciaServicio.listar();
        model.addAttribute("referenciasCrono", lista);
        return "cronogramaAdministrador";
    }
    
     @GetMapping("/cronoProfesor")
    public String profesorCronograma(Profesor profesor, Model model)
    {
        List<ModuloReferencia> lista = null;
        lista = modRefServicio.listarPorProfesor(profesor);
        model.addAttribute("modulosProfesor", lista);
        return "cronogramaProfesor";
    }
}
