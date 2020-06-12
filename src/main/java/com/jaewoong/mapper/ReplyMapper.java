package com.jaewoong.mapper;

import com.jaewoong.domain.ReplyVO;

public interface ReplyMapper {
    public int insert(ReplyVO vo);

    public ReplyVO read(Long bno);
    //특정 댓글의 삭제는 댓글의 번호(rno)만 처리가 가능하다.
    public int delete(Long bno);
}
