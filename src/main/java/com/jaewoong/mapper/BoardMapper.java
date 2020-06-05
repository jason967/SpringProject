package com.jaewoong.mapper;

import com.jaewoong.domain.BoardVO;
import com.jaewoong.domain.Criteria;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardMapper {
    public List<BoardVO> getList();

    public void insert(BoardVO board);

    public List<BoardVO> getListWithPaging(Criteria cri);

    public void insertSelectKey(BoardVO board);

    public BoardVO read(Long bno);

    public int delete(Long bno);

    public int update(BoardVO board);
    //@Select("select * from tbl_board where bno >0")

}
