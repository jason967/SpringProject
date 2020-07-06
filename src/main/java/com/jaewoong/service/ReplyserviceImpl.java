package com.jaewoong.service;

import com.jaewoong.domain.Criteria;
import com.jaewoong.domain.ReplyPageDTO;
import com.jaewoong.domain.ReplyVO;
import com.jaewoong.mapper.BoardMapper;
import com.jaewoong.mapper.ReplyMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j
public class ReplyserviceImpl implements ReplyService {

    //등록과 삭제 부분은 트랙잭션 구성이 필요함

    @Setter(onMethod_ =@Autowired)
    private ReplyMapper mapper;

    @Setter(onMethod_ = @Autowired)
    private  BoardMapper boardMapper;

    @Transactional
    @Override
    public int register(ReplyVO vo)
    {
        log.info("register...."+vo);
        boardMapper.updateReplyCnt(vo.getBno(),1);
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

    @Transactional
    @Override
    public int remove(Long rno) {
        log.info("remove...."+rno);

        ReplyVO vo =mapper.read(rno);
        boardMapper.updateReplyCnt(vo.getBno(),-1);
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
