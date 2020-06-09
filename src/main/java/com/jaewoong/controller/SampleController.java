package com.jaewoong.controller;

import com.jaewoong.domain.SampleVO;
import lombok.extern.log4j.Log4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/sample")
@Log4j

public class SampleController {

    @GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
    public String getText()
    {
        log.info("MINE TYPE: " + MediaType.TEXT_PLAIN_VALUE);

        return "안녕하세요";
    }


    @GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
    public SampleVO getSample()
    {
        return new SampleVO(112,"스타","로드");
    }

    @GetMapping(value = "/getSample2")
    public SampleVO getSample2()
    {
        return new SampleVO(113,"로켓","라쿠");
    }

    @GetMapping(value = "/getList")
    public List<SampleVO> getList()
    {
        return IntStream.range(1,10).mapToObj(i->new SampleVO(i,i+"First",i+"Last")).collect(Collectors.toList());
    }

    @GetMapping(value = "/getMap")
    public Map<String,SampleVO> getMap()
    {
        Map<String,SampleVO> map = new HashMap<>();
        map.put("First", new SampleVO(111,"그루트","주니어"));
        return map;
    }
}

