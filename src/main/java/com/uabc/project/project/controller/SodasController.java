package com.uabc.project.project.controller;

import com.uabc.project.project.model.Cigarros;
import com.uabc.project.project.model.Sodas;
import com.uabc.project.project.services.CigarrosService;
import com.uabc.project.project.services.SodasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SodasController {

    @Autowired SodasService sodasService;


    @GetMapping("/mostrarSodas")
    public String mostrarSodas(Model model){

        List<Sodas> sodas = sodasService.todos();
        model.addAttribute("sodas", sodas);

        return "sodas";
    }

    //FORMULARIO PARA SODAS
    @GetMapping("/formSodas")
    public String formSodas(Model model) {
        model.addAttribute("sodas", new Sodas());
        return "registro_sodas";
    }

    //GUARDAR SODAS
    @PostMapping("/saveSodas")
    public String saveSodas(@ModelAttribute Sodas sodas, Model model) {
        model.addAttribute("sodas", sodas);
        //GUARDANDO EL ARTICULO EN LA BD
        sodasService.add(sodas);
        return "redirect:/";
    }
}
