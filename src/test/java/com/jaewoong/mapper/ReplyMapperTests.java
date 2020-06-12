package com.jaewoong.mapper;

import com.jaewoong.domain.Criteria;
import com.jaewoong.domain.ReplyVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/rootContext.xml")
@Log4j
public class ReplyMapperTests
{
   @Setter(onMethod_= @Autowired)
   private ReplyMapper mapper;

   @Test
   public void testMapper()
   {
      log.info(mapper);
   }
   private Long[] bnoArr = {12202L,201L,202L,203L,204L};

   @Test
   public void testCreate()
   {
      IntStream.rangeClosed(1,10).forEach(i->
      {
         ReplyVO vo = new ReplyVO();

         vo.setBno(bnoArr[i%5]);
         vo.setReply("댓글리스트 "+i);
         vo.setReplyer("replyer"+i);

         mapper.insert(vo);
      });

   }

   @Test
   public void testRead()
   {
      Long targetRno = 5L;
      ReplyVO vo= mapper.read(targetRno);
      log.info(vo);
   }

   @Test
   public void testDelete()
   {
      Long targetRno = 201L;
      mapper.delete(targetRno);
   }

   @Test
   public void testUpdate()
   {
      Long targetRno = 10L;
      ReplyVO vo = mapper.read(targetRno);
      vo.setReplyer("update Reply ");
      int count = mapper.update(vo);
      log.info("UPDATE COUNT: "+count);
   }

   @Test
   public void testList()
   {
      Criteria cri = new Criteria();
      List<ReplyVO> replies = mapper.getListWithPaging(cri,bnoArr[0]);

      replies.forEach(reply -> log.info(reply));
   }

}