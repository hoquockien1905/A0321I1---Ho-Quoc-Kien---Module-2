package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String index(Model model, @RequestParam(name = "success") Optional<String> success){
        model.addAttribute("customers",customerService.findAll());
        if(success.isPresent()) {
            model.addAttribute("success", success);
        }
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirectAttributes){
        customer.setId((int)(Math.random() * 100));
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success","Thêm thành công!");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Customer customer){
        customerService.update(customer);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView model = new ModelAndView("/delete","customer",customerService.findById(id));
        return model;
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirectAttributes){
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("success","Xoá thành công");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "view";
    }
}
