package com.tugas5.apotek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tugas5.apotek.model.Login;
import com.tugas5.apotek.service.LoginService;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;


    // Melakukan register 
    @GetMapping("/register")
    public String register(Model model){
        Login login = new Login();
        model.addAttribute("regis",login);
        return "register";
    }

    // menyimpan data register
    @PostMapping("/save-regis")
    public String saveRegis(@ModelAttribute ("regis") Login login){
        loginService.save(login);
        return "redirect:/login";
    }


    @GetMapping("/login")
    public String login(){
        return "login"; //mengembalikan nama template html
    }


    // mengecek di saat login apakah sesuai dengan database atau tidak
    @PostMapping("/cek-login")
    public String login(@RequestParam ("username") String username, 
                        @RequestParam ("password") String password, Model model){
        Login login = loginService.findByUsernameAndPassword(username, password);
        if(login != null){
            model.addAttribute("login",login);
            return "redirect:/home";
        }else{
            return "redirect:/login";
        }
    }

}
