package com.jaewoong.service;

import com.jaewoong.domain.BoardVO;
import com.jaewoong.domain.Criteria;

import java.util.List;

public interface BoardService {

    public void register(BoardVO board);

    public BoardVO get(Long bno);

    public boolean modify(BoardVO board);

    public boolean remove(Long bno);

    //public List<BoardVO> getList();

    public int getTotal(Criteria cri);

    public List<BoardVO> getList(Criteria cri);
}
