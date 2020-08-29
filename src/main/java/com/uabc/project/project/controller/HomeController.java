package com.uabc.project.project.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping("/")
    @Secured("ROLE_USER")
    public String home(Map<String, Object> model){
        model.put("message", "BIENVENIDO");
        model.put("title", "HOME");
        model.put("date", new Date());
        return "index";
    }
}
