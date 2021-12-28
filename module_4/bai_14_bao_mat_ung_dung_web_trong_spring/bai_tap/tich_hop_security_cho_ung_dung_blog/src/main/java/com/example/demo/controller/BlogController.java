package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public String showList(Model model, @PageableDefault (size = 4) Pageable pageable,
                           Optional<String> searchKey,
                           Optional<Integer> categoryId) {
        model.addAttribute("categoryList", categoryService.findAll());
        if (searchKey.isPresent()) {
            model.addAttribute("blogList", blogService.findAllByAuthorContains(searchKey.get(), pageable));
        } else {
            if (categoryId.isPresent()) {
                model.addAttribute("blogList", blogService.findAllByCategory(categoryId.get(), pageable));
            } else {
                model.addAttribute("blogList", blogService.findAllBlog(pageable));
            }
        }
        return "/blog/list";
    }

    @GetMapping("/admin/create")
    public String showFormCreate(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }

    @PostMapping("/admin/create")
    public String create(@ModelAttribute ("blog") Blog blog, Model model) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/admin/edit/{id}")
    public String showEdit(@PathVariable ("id") int id, Model model) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            model.addAttribute("blog", blogService.findById(id));
            model.addAttribute("categories", categoryService.findAll());
        }
        return "/blog/edit";
    }

    @PostMapping("/admin/edit")
    public String edit(@ModelAttribute ("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Update successfully!");
        return "redirect:/";
    }

    @GetMapping("/admin/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("deleteMessage", "Deleted successfully!");
        return "redirect:/";
    }

    @GetMapping("/admin")
    public String showListAdmin(Model model, @PageableDefault (size = 4) Pageable pageable,
                           Optional<String> searchKey,
                           Optional<Integer> categoryId) {
        model.addAttribute("categoryList", categoryService.findAll());
        if (searchKey.isPresent()) {
            model.addAttribute("blogList", blogService.findAllByAuthorContains(searchKey.get(), pageable));
        } else {
            if (categoryId.isPresent()) {
                model.addAttribute("blogList", blogService.findAllByCategory(categoryId.get(), pageable));
            } else {
                model.addAttribute("blogList", blogService.findAllBlog(pageable));
            }
        }
        return "/blog/admin";
    }
}
