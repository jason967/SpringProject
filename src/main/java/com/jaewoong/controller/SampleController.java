package com.jaewoong.controller;



import com.jaewoong.domain.SampleDTO;
import com.jaewoong.domain.SampleDTOList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.extern.log4j.Log4j;

import java.util.ArrayList;

@Controller
@RequestMapping("/sample/*")
@Log4j

public class SampleController {
    @RequestMapping("")
    public void basic(){
        log.info("basic.........");
    }
    @GetMapping("/ex01")
    public String  ex01(SampleDTO dto)
    {
        log.info(""+dto);
        return "ex01";
    }
    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name,@RequestParam("age") int age)
    {
        log.info("name"+name);
        log.info("age"+age);
        return "ex02";
    }
    @GetMapping("/ex02list")
    public String ex02(@RequestParam("ids") ArrayList<String> ids)
    {
        log.info("ids: "+ids);
        return "ex02list";
    }
    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list)
    {
        log.info("list dtos: "+list);
        return "ex02Bean";
    }
    //객체로 받아 오는거 아니라 기본 자료형이라면 ModelAttribute 써야함
    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page)
    {
        log.info("dto: "+dto);
        log.info("page: "+page);

        return "/sample/ex04";
    }
    @GetMapping("/ex06")
    public @ResponseBody SampleDTO ex06()
    {
        log.info("/ex06..........");
        SampleDTO dto = new SampleDTO();
        dto.setAge(10);
        dto.setName("박동진");

        return dto;
    }
}
