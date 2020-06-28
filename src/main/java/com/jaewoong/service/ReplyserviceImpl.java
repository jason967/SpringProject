package com.jaewoong.service;

import com.jaewoong.domain.Criteria;
import com.jaewoong.domain.ReplyPageDTO;
import com.jaewoong.domain.ReplyVO;
import com.jaewoong.mapper.ReplyMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class ReplyserviceImpl implements ReplyService {

    @Setter(onMethod_ =@Autowired)
    private ReplyMapper mapper;

    @Override
    public int register(ReplyVO vo)
    {
        log.info("register...."+vo);
        return mapper.insert(vo);
    }

    @Override
    public ReplyVO get(Long rno) {
        log.info("get......."+rno);
        return mapper.read(rno);
    }

    @Override
    public int modify(ReplyVO vo) {
        log.info("modify....."+vo);
        return mapper.update(vo);
    }

    @Override
    public int remove(Long rno) {
        log.info("remove...."+rno);
        return mapper.delete(rno);
    }

    @Override
    public List<ReplyVO> getList(Criteria cri, Long bno) {
        log.info("get Reply of a Board "+bno);
        return mapper.getListWithPaging(cri,bno);
    }

    @Override
    public ReplyPageDTO getListPage(Criteria cri, Long bno) {
        return new ReplyPageDTO(
                mapper.getCountByBno(bno),
                mapper.getListWithPaging(cri,bno)
        );
    }
}
