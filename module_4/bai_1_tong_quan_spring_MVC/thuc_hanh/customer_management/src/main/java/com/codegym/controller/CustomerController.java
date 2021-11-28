package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.impl.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerService customerService = new CustomerServiceImpl();

    @GetMapping
    public String showList(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("listCustomer", customers);
        return "list";
    }

    @GetMapping("/{id}")
    public ModelAndView showInfo(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("info");
        Customer customer = customerService.findById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping
    public String update(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String address
    ) {
        customerService.update(id, name, email, address);
        return "redirect:/";
    }
}
