package com.jaewoong.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}