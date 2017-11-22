/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author binod
 */
@Controller
public class DefaultController {
    @GetMapping("/")
    public String home1(){
        return "home";
        
    }
//    @GetMapping("/home")
//    public String home(){
//        return "home";
//    }
//    @GetMapping("/admin")
//    public String admin() {
//        return "/admin";
//    }
//
    @GetMapping("/user")
    public String user() {
        return "/user";
    }
//
//    @GetMapping("/about")
//    public String about() {
//        return "/about";
//    }
//
    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
    @GetMapping("/department")
    public String loadDepartmentPage(){
        return "/department";
    }
    
}
