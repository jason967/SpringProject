package com.jaewoong.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BoardVO {

    private long bno;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private Date updateDate;

    private int replyCnt;
}
