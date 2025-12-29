package com.sunny.enterprise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class WebController {

    @GetMapping("/welcome")
    public String welcomePage(@RequestParam(name="name", required=false, defaultValue="Guest") String name, Model model) {
        // This 'name' is passed to the HTML template
        model.addAttribute("name", name);
        
        // This refers to src/main/resources/templates/welcome.html
        return "welcome"; 
    }
}