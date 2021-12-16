package com.example.demo.controller;

import com.example.demo.exceptions.BorrowException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BorrowException.class)
    public String borrowException(BorrowException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "error_page/error_borrow";
    }
}
