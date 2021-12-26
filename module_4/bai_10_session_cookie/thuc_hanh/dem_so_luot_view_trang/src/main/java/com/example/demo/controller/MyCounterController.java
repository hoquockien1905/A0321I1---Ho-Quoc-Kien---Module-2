package com.example.demo.controller;

import com.example.demo.model.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//tạo session có tên myCounter
@SessionAttributes("myCounter")
public class MyCounterController {

    // Truy cập session có tên myCounter
    //nếu Session trống thì đưa lên một new MyCounter
    @ModelAttribute("myCounter")
    public MyCounter setUpCount() {
        return new MyCounter();
    }

    @GetMapping("")
    public String get(@ModelAttribute("myCounter") MyCounter myCounter) {
        myCounter.increment();
        return "index";
    }
}
