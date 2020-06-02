package com.jaewoong.domain;

import lombok.Data;

@Data
public class BoardVO {

    private long bno;
    private String title;
    private String content;
    private String writer;
    private Data reData;
    private Data upDateData;
}
