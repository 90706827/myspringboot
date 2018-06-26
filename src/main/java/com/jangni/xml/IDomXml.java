package com.jangni.xml;

import org.dom4j.DocumentException;

import java.util.ArrayList;

/**
 * @program: myspringboot
 * @description:
 * @author: Mr.Jangni
 * @create: 2018-05-29 21:59
 **/
public abstract class IDomXml<T> {


    abstract T reader(String xml) throws DocumentException;

    abstract String wirter(T t);
}
