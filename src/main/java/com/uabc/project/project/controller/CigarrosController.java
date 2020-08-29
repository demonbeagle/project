package com.uabc.project.project.controller;

import com.uabc.project.project.model.Cigarros;
import com.uabc.project.project.services.CigarrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CigarrosController {

    @Autowired CigarrosService cigarrosService;


    @GetMapping("/mostrarCigarros")
    public String mostrarGigarros(Model model){

        List<Cigarros> cigarros = cigarrosService.todos();
        model.addAttribute("cigarros", cigarros);

        return "cigarros";
    }

    //FORMULARIO PARA CIGARROS
    @GetMapping("/formCigarros")
    public String formCigarross(Model model) {
        model.addAttribute("cigarros", new Cigarros());
        return "registro_cigarros";
    }

    //GUARDAR CIGARROS
    @PostMapping("/saveCigarros")
    public String saveCigarros(@ModelAttribute Cigarros cigarros, Model model) {
        model.addAttribute("cigarros", cigarros);
        //GUARDANDO EL ARTICULO EN LA BD
        cigarrosService.add(cigarros);
        return "redirect:/";
    }

}
