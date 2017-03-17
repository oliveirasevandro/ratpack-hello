package com.evandro.oliveira.ratpack.hello.pojo;

/**
 * Created by eso on 17/03/17.
 */
public class Employee {

    private Long id;
    private String title;
    private String name;

    public Employee(long id, String title, String name) {
        this.id = id;
        this.title = title;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
