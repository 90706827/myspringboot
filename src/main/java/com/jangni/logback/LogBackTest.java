package com.jangni.logback;

/**
 * @program: myspringboot
 * @description: test
 * @author: Mr.Jangni
 * @create: 2018-05-24 22:09
 **/
public class LogBackTest implements ILogBack {
    public static void println() {
        logerror.trace("trace");
        logerror.debug("debug");
        logerror.info("info");
        logerror.warn("warn");
        logerror.error("error");
    }
}
