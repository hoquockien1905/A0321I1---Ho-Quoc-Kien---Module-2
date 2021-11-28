package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(.[A-Za-z0-9]+)$";

    private boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public EmailController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @GetMapping("")
    public String home() {
        return "home";
    }

    @PostMapping("")
    private String validateEmail(@RequestParam String email, Model model) {
        boolean isValid = this.validate(email);
        if (!isValid) {
            model.addAttribute("email", "Email is invalid!");
            model.addAttribute("red", "red");
            return "home";
        }
        model.addAttribute("email", "successfully! " + email);
        return "home";
    }
}
