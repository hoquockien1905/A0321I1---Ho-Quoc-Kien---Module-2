package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class UserController {

    @ModelAttribute("user")
    public User setUser() {
        return new User();
    }

    @GetMapping("/login")
    public String index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        return "login";
    }

    @PostMapping("/doLogin")
    public String login(@ModelAttribute("user") User user, Model model, @CookieValue(value = "setUser", defaultValue = "") String setUser,
                        HttpServletRequest request, HttpServletResponse response) {
            if (user.getEmail().equals("hquockien@gmail.com") && user.getPassword().equals("123456")) {
                setUser = user.getEmail();
                Cookie cookie = new Cookie("setUser", setUser);
                cookie.setMaxAge(60 * 60);
                response.addCookie(cookie);
                Cookie[] cookies = request.getCookies();

                for (Cookie ck: cookies) {
                    if (ck.getName().equals("setUser")) {
                        model.addAttribute("cookieValue", ck);
                        break;
                    } else {
                        ck.setValue("");
                        model.addAttribute("cookieValue", ck);
                        break;
                    }
                }
                model.addAttribute("message", "Login success. Welcome ");
            } else {
                user.setEmail("");
                Cookie cookie = new Cookie("setUser", setUser);
                model.addAttribute("cookieValue", cookie);
                model.addAttribute("message", "Login failed. Try again.");
            }
        return "login";
    }
}
