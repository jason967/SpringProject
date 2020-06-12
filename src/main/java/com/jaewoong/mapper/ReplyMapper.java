package com.jaewoong.mapper;

import com.jaewoong.domain.Criteria;
import com.jaewoong.domain.ReplyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {

    public int insert(ReplyVO vo);

    public ReplyVO read(Long bno);

    public int delete(Long bno);

    public int update(ReplyVO vo);

    public List<ReplyVO> getListWithPaging(
            @Param("cri")Criteria cri,
            @Param("bno") Long bno);
}
