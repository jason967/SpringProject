package com.jaewoong.controller;

import com.jaewoong.domain.SampleDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sample/*")
@Log4j

public class SampleController {
    @RequestMapping("")
    public void basic() {
        log.info("basic..............");
        System.out.println("hi");
    }
    @RequestMapping("/ex01")
    public String ex01(SampleDTO dto)
    {
        log.info(""+dto);
        return "ex01";
    }
    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("age") int age)
    {
        log.info("name: "+name);
        log.info("age: "+age);
        return "ex02";
    }

}