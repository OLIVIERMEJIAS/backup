/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Controladores;

import com.DeiviOlivier.CronogramaFase2.Dominios.Administrador;
import com.DeiviOlivier.CronogramaFase2.Dominios.Profesor;
import com.DeiviOlivier.CronogramaFase2.Servicios.IAdministradorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author HP
 */
@Controller
public class AdministradorControlador {
    @Autowired
    private IAdministradorServicio adminServ;
    @GetMapping("/contrasenaAdministrador")
    public String cambioAdministrador(Administrador administrador){
        return "cambioContrasenaAdministrador";
    }
    @GetMapping("/cambioAdministrador")
    public String cambioContraseña(Administrador administrador,RedirectAttributes red){
        Administrador aux = null;
        aux = adminServ.obtenerAdministrador(administrador.getIdAdministrador());
        if(aux != null){
            if(administrador.getContrasenaAdministrador().equals(administrador.getContrasenaRepetida())){
                adminServ.guardar(administrador);
            }
            else{
                red.addFlashAttribute("msg", "La contraseña no concuerda con la repetición de la esta!");
                red.addFlashAttribute("administrador", administrador);
                return "redirect:/contrasenaAdministrador";
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
