package com.jaewoong.persistant;

import com.jaewoong.mapper.TimeMapper;
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

public class TimeMapperTests {
    @Setter(onMethod_ = @Autowired)
    private TimeMapper timeMapper;

    @Test
    public void testGetTime()
    {
        log.info(timeMapper.getClass().getName());
        log.info(timeMapper.getTime());
    }
}
