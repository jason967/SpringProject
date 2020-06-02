package com.jaewoong.exception;

import lombok.extern.log4j.Log4j;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
//해당 객체가 스프링의 컨트롤러에서 발생하는 예외를 처리하는 존재임을 명시
@Log4j
public class CommonExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public String exception(Exception ex, Model model)
    {
        log.error("Exception......"+ex.getMessage());
        model.addAttribute("exception",ex);
        return "error/error_page";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException ex) {
        log.error("error404");
        return "error/custom404";
    }
}
