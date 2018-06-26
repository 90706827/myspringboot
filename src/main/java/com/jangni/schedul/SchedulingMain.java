package com.jangni.schedul;

import com.jangni.logback.LogBackTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @program: myspringboot
 * @description:
 * @author: Mr.Jangni
 * @create: 2018-05-26 22:28
 **/
@Component
public class SchedulingMain {

    private final Logger logger = LoggerFactory.getLogger(SchedulingMain.class);
    @Scheduled(fixedRate = 10000)
    public void testTask(){
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        LogBackTest.println();
    }
}
