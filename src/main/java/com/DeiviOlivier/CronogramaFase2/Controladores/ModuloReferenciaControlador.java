/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Controladores;

import com.DeiviOlivier.CronogramaFase2.Dominios.Modulo;
import com.DeiviOlivier.CronogramaFase2.Dominios.ModuloReferencia;
import com.DeiviOlivier.CronogramaFase2.Dominios.Referencia;
import com.DeiviOlivier.CronogramaFase2.Servicios.IModuloReferenciaServicio;
import com.DeiviOlivier.CronogramaFase2.Servicios.IModuloServicio;
import com.DeiviOlivier.CronogramaFase2.Servicios.IReferenciaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author HP
 */
@Controller
public class ModuloReferenciaControlador {
    @Autowired
    private IModuloReferenciaServicio modServicio;
    @Autowired
    private IReferenciaServicio refServicio;
    @Autowired
    private IModuloServicio moduloServicio;
    @GetMapping("/modulosReferencia/{idReferencia}")
    public String inicio(Referencia referencia,Model model){
        List<ModuloReferencia> lista;
        List<Modulo> listaSeleccionar = null;
        referencia = refServicio.obtenerReferencia(referencia.getIdReferencia());
        if(referencia.getProgramaReferencia() != null)
        {
            listaSeleccionar = moduloServicio.listar(referencia.getProgramaReferencia().getIdPrograma());
        }
        else if (referencia.getModuloReferencia() != null)
        {
            listaSeleccionar = moduloServicio.listar(referencia);
        }
        lista = modServicio.listar(referencia);
        model.addAttribute("referencia", referencia);
        model.addAttribute("modSeleccionar", listaSeleccionar);
        model.addAttribute("modulosR", lista);
        return "listaModulosReferencia";
    }
    
    
}
