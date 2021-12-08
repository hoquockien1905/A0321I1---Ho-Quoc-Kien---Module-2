package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Customer customer, Model model) {
        customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("customer", new Customer());
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("customer") Customer customer, Model model) {
        customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        customerService.remove(id);
        return "redirect:/";
    }

}
