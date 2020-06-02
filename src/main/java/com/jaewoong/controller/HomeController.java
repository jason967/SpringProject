package com.jaewoong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

   // @GetMapping("/")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(Model model)
    {
        return "home/index";
    }
}