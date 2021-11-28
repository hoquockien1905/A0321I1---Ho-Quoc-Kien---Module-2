package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {

    @GetMapping("")
    public String showFormConvert() {
        return "convert";
    }

    @PostMapping("")
    public String convert(@RequestParam String usd, Model model) {
        double result = Double.parseDouble(usd) * 23000;
        model.addAttribute("result", result);
        return "result";
    }

}
