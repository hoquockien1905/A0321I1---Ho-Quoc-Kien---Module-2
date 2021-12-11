package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserValidator userValidator;

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping("")
    public String validateForm(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registerForm";
        }
        userService.save(user);
        model.addAttribute("user", user);
        return "result";
    }
}
