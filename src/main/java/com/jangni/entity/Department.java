package com.jangni.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Autor: Jangni
 * @Date: Created in  2018/3/1/001 22:49
 */
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
