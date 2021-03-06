package com.jangni.xml;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: myspringboot
 * @description: Xml解析
 * @author: Mr.Jangni
 * @create: 2018-05-29 19:22
 **/
public class DOM4JTest {
    // 接收书籍实体的集合
    private static ArrayList<Book> bookList = new ArrayList<Book>();

    public static ArrayList<Book> getBookList() {
        return bookList;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        {
            // Dom4j解析books.xml
            // 创建的对象reader
            SAXReader reader = new SAXReader();
            reader.setEncoding("UTF-8");
            try {
                String abc ="<bookstore>" +
                        "<book id='1'>" +
                        "<name>懂得生活</name>" +
                        "<author>Mr Azzan</author>" +
                        "<year>2017</year>" +
                        "<price>100.00</price>" +
                        "</book>"+
                        "</bookstore>";
                // 通过reader对象的read方法加载books.xml文件，获取document对象
                Document document = (Document) DocumentHelper.parseText(abc);
                // 通过document对象获取根节点bookstore
                Element bookstore = document.getRootElement();
                // 通过element对象的elementIterator方法获取迭代器
                Iterator it = bookstore.elementIterator();
                // 全局变量记录第几本书籍
                int num = 0;
                // 遍历迭代器，获取根节点中的信息(书籍)
                while (it.hasNext()) {
                    Book bookEntity = new Book();
                    num++;
                    System.out.println("====开始遍历" + num + "本书====");
                    Element book = (Element) it.next();
                    // 获取book的属性名以及属性值
                    List<Attribute> bookAttrs = book.attributes();
                    for (Attribute attr : bookAttrs) {
                        System.out.println("属性名：" + attr.getName() + "--属性值："
                                + attr.getStringValue());
                        bookEntity.setId(attr.getStringValue());
                    }
                    // 解析子节点的信息
                    Iterator itt = book.elementIterator();
                    while (itt.hasNext()) {
                        Element bookChild = (Element) itt.next();
                        System.out.println("节点名：" + bookChild.getName() + "--节点值："
                                + bookChild.getStringValue());

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
                    // 将书籍存入书籍集合中
                    bookList.add(bookEntity);
                    // 将书籍实体设置为null，节省资源
                    bookEntity = null;
                    System.out.println("====结束遍历" + num + "本书====");
                    System.out.println();//换行
                }
            } catch (DocumentException e) {
                e.printStackTrace();
            }

            // 验证书籍集合中是否成功存入书籍
            for (Book b : bookList) {
                System.out.println("++++开始++++");
                System.out.println(b.getId());
                System.out.println(b.getName());
                System.out.println(b.getAuthor());
                System.out.println(b.getYear());
                System.out.println(b.getPrice());
                System.out.println("++++结束++++");
                System.out.println();//换行
            }
        }
    }


    public void writer(Document document) throws Exception {
        // 紧凑的格式
        // OutputFormat format = OutputFormat.createCompactFormat();
        // 排版缩进的格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        // 设置编码
        format.setEncoding("UTF-8");
        // 创建XMLWriter对象,指定了写出文件及编码格式
        // XMLWriter writer = new XMLWriter(new FileWriter(new
        // File("src//a.xml")),format);
        XMLWriter writer = new XMLWriter(new OutputStreamWriter(
                new FileOutputStream(new File("src//a.xml")), "UTF-8"), format);
        // 写入
        writer.write(document);
        // 立即写入
        writer.flush();
        // 关闭操作
        writer.close();
    }
}
