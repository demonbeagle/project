package com.uabc.project.project.controller;


import com.uabc.project.project.model.User;
import com.uabc.project.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("index")
    @Secured("ROLE_USER")
    public String index(Model model){

        model.addAttribute("users", service.obtenerTodosUsuario());

        return "index";
    }

    @GetMapping("agregar")
    @Secured("ROLE_USER")
    public String registrar(User user) {
        return "add-user";
    }

    @GetMapping("eliminar/{id}")
    @Secured("ROLE_USER")
    public String eliminar(@PathVariable("id")long laID, Model model) {

        service.eliminarUsuario(laID);

        model.addAttribute("users", service.obtenerTodosUsuario());

        return "index";
    }


    @PostMapping("/adduser")
        @Secured("ROLE_USER")
    public String addUser(User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "add-user";
        }
        service.registrarUsuario(user);

       return "redirect:/";
    }


}
