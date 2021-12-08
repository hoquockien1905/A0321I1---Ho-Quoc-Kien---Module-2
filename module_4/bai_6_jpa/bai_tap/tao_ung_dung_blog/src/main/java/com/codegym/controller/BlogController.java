package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogs", blogService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute ("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }

    @GetMapping("/content/{id}")
    public String showContent(@PathVariable("id") Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "content";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("blog", blogService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute ("blog") Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        blogService.remove(id);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
