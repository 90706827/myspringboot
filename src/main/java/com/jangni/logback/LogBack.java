package com.jangni.logback;


/**
 * @program: myspringboot
 * @description:
 * @author: Mr.Jangni
 * @create: 2018-05-24 20:58
 **/
public class LogBack implements ILogBack {
    public static void main(String[] args) throws Exception {
        while (true) {

            logbase.trace("trace");
            logbase.debug("debug");
            logbase.info("info");
            logbase.warn("warn");
            logbase.error("error");
            LogBackTest.println();
            Thread.sleep(3000);
        }
    }
}
