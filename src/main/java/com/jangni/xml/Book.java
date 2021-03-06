package com.jangni.xml;

/**
 * @program: myspringboot
 * @description:
 * @author: Mr.Jangni
 * @create: 2018-05-29 19:27
 **/
public class Book {
    private String id;
    private String name;
    private String author;
    private String year;
    private String price;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
