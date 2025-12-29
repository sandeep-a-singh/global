package com.sunny.enterprise.controller;

import com.sunny.enterprise.dto.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @GetMapping("/register")
    public String showForm(Model model) {
        // We pass an empty object to bind the form fields to
        model.addAttribute("person", new Person());
        return "register";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute Person person, Model model) {
        // Here you can save to a DB or log the data
      model.addAttribute("message", "Hello " + person.getFirstName() + " " + person.getLastName() + "!");
        return "welcome";
    }
}