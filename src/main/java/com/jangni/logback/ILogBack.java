package com.jangni.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface ILogBack {
    Logger logbase = LoggerFactory.getLogger("base");
    Logger logerror = LoggerFactory.getLogger("error");
}
