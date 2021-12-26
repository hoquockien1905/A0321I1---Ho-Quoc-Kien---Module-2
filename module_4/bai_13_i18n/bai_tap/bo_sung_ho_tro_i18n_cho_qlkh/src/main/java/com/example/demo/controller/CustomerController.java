package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.ICustomerService;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @Autowired
    MessageSource messageSource;

    @GetMapping("/")
    public String getList(Model model) {
        model.addAttribute("customerList", customerService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String formNewCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        customerService.save(customer);
        String message = messageSource.getMessage("add.success", null, "Thêm mới thành công", request.getLocale());
        redirectAttributes.addFlashAttribute("addSuccess", message );
        return "redirect:/";
    }
}
