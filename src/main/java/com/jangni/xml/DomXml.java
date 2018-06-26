package com.jangni.xml;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: myspringboot
 * @description: 2
 * @author: Mr.Jangni
 * @create: 2018-05-29 21:12
 **/
public class DomXml extends IDomXml {
    private ArrayList<Book> list = new ArrayList<Book>();

    @Override
    ArrayList<Book> reader(String xml) throws DocumentException {
        SAXReader reader = new SAXReader();
        reader.setEncoding("UTF-8");
        Document document = DocumentHelper.parseText(xml);
        Element bookstore = document.getRootElement();
        Iterator it = bookstore.elementIterator();
        int num = 0;
        while (it.hasNext()) {
            Book bookEntity = new Book();
            num++;
            Element book = (Element) it.next();
            List<Attribute> bookAttrs = book.attributes();
            for (Attribute attr : bookAttrs) {
                bookEntity.setId(attr.getStringValue());
            }
            // 解析子节点的信息
            Iterator itt = book.elementIterator();
            while (itt.hasNext()) {
                Element bookChild = (Element) itt.next();
                if (bookChild.getName().equals("name")) {
                    bookEntity.setName(bookChild.getStringValue());
                }
                if (bookChild.getName().equals("author")) {
                    bookEntity.setAuthor(bookChild.getStringValue());
                }
                if (bookChild.getName().equals("year")) {
                    bookEntity.setYear(bookChild.getStringValue());
                }
                if (bookChild.getName().equals("price")) {
                    bookEntity.setPrice(bookChild.getStringValue());
                }
            }
            list.add(bookEntity);
            bookEntity = null;
        }
        return list;
    }

    @Override
    String wirter(Object o) {
        return null;
    }


}
