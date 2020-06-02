package com.jaewoong.mapper;

import com.jaewoong.domain.BoardVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardMapper {
    public List<BoardVO> getList();
    //@Select("select * from tbl_board where bno >0")

}
