package com.jaewoong.domain;

import lombok.Data;

import java.util.Date;
@Data
public class ReplyVO {
    private Long rno =0L;
    private Long bno;

    private String reply;
    private String replyer;
    private Date replyDate;
    private Date updateDate;
}
