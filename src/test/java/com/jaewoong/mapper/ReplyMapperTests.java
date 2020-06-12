package com.jaewoong.mapper;

import com.jaewoong.domain.ReplyVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.IntStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/rootContext.xml")
@Log4j
public class ReplyMapperTests
{
   @Setter(onMethod_= @Autowired)
   private ReplyMapper mapper;

   private Long[] bnoArr={12201L,12202L,12203L,12204L,12205L};

    @Test
   public void testCreate()
    {
       IntStream.rangeClosed(1,10).forEach(i->
       {
          ReplyVO vo = new ReplyVO();

          vo.setBno(bnoArr[i%5]);
          vo.setReply("댓글리스트: "+i);
          vo.setReplyer("replyer"+i);

          mapper.insert(vo);
       });
    }

   @Test
   public void testMapper()
   {
      log.info(mapper);
   }

   @Test
   public void testRead()
   {
      Long targetRno=10L;
      ReplyVO vo =mapper.read(targetRno);
      log.info(vo);
   }

   @Test
   public void testDelete()
   {
      Long targetRno = 10L;
      mapper.delete(targetRno);
   }
}