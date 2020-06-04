package com.jaewoong.controller;


import com.jaewoong.domain.BoardVO;
import com.jaewoong.service.BoardService;
import com.jaewoong.service.BoardServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j
@RequestMapping("/board/")
@AllArgsConstructor

public class BoardController {
    private BoardService service;

    @GetMapping("/list")
    public void list(Model model)
    {
        log.info("list");
        model.addAttribute("list",service.getList());
    }


    @GetMapping("/register")
    public void register(){
        log.info("GET_register");
    }

    @PostMapping("/register")
    public String register(BoardVO board, RedirectAttributes rttr)
    {
        log.info("POST_register: "+board);
        log.info("시작한다");
        service.register(board);
        log.info("들어왔어");
        rttr.addFlashAttribute("result",board.getBno());

        return "redirect:/board/list";
    }

    @GetMapping({"/get","/modify"})
    public void get(@RequestParam("bno") Long bno,Model model)
    {
        log.info("/get or modify");
        model.addAttribute("board",service.get(bno));
    }

    @PostMapping("/modify")
    public String modify(BoardVO board, RedirectAttributes rttr)
    {
        log.info("modify"+board);

        if(service.modify(board))
        {
            rttr.addFlashAttribute("result","success");
        }
        return "redirect:/board/list";
    }
    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno,RedirectAttributes rttr)
    {
        log.info("remove...."+bno);
        if(service.remove(bno))
        {
            rttr.addFlashAttribute("result","sucess");
        }
        return "redirect:/board/list";
    }
}