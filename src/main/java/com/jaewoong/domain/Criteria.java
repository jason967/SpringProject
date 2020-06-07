package com.jaewoong.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.servlet.mvc.method.annotation.UriComponentsBuilderMethodArgumentResolver;
import org.springframework.web.util.UriComponentsBuilder;

@Getter
@Setter
@ToString
public class Criteria {

    private int pageNum;
    private int amount;

    private String type;
    private String keyword;

    public Criteria()
    {
        this(1,10);
    }

    public Criteria(int pageNum,int amount)
    {
        this.pageNum=pageNum;
        this.amount=amount;
    }

    public String getListLink()
    {
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("pageNum",this.pageNum)
                .queryParam("amount",this.amount)
                .queryParam("type",this.type)
                .queryParam("keyword",this.keyword);
        return builder.toUriString();
    }

    public String[] getTypeArr()
    {
        return type ==null? new String[] {} :type.split("");
    }
}
