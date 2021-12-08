package com.codegym.controller;

import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {

    private static List<String> languages = new ArrayList<>();

    static {
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Chinese");
        languages.add("Japanese");
    }

    private static List<Integer> pageSizeList = new ArrayList<>();

    static {
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
    }

    @GetMapping("")
    public String setting(Model model) {
        model.addAttribute("languages", languages);
        model.addAttribute("pageSizeList", pageSizeList);
        model.addAttribute("email", new Email());
        return "config";
    }

    @PostMapping("")
    public String info(@ModelAttribute ("email") Email email, Model model) {
        model.addAttribute("email", email);
        return "info";
    }
}
