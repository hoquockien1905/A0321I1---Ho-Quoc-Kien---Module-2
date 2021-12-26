package com.example.demo.controller;

import com.example.demo.model.Smartphone;
import com.example.demo.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/smartphone")
public class SmartphoneController {

    @Autowired
    ISmartphoneService smartphoneService;

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("phone/create");
        modelAndView.addObject("newPhone", new Smartphone());
        return modelAndView;
    }
}
