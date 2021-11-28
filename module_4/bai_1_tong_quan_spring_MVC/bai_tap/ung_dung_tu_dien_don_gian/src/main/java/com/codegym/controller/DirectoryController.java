package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DirectoryController {

    private static Map<String, String> directoryMap;

    static {
        directoryMap = new HashMap<>();
        directoryMap.put("hello", "xin chao");
        directoryMap.put("goodbye", "tam biet");
        directoryMap.put("book", "sach");
        directoryMap.put("thank you", "cam on");
    }

    @GetMapping("")
    public String home() {
        return "home";
    }

    @PostMapping("")
    public String translate(@RequestParam String eng, Model model) {
        eng = eng.trim().toLowerCase();
        String vn = directoryMap.get(eng);
        if (vn == null) {
            model.addAttribute("result", "khong tim thay");
        } else {
            model.addAttribute("result", vn);
        }
        model.addAttribute("eng", eng);
        return "home";
    }
}
