package com.module.seed.model;

import org.springframework.stereotype.Component;

// todo: 需要 bean化,否则无法在define.xml中使用表达式属性
 public class Person {
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}