package com.EasyToCode.Employee.Management.Demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="first_name")
    private String name;

    @Column(name="second_name")
    private String surName;

    @Column(name="age")
    private int age;

    @Column(name="email", unique = true)
    private String email;

    @Column(name="title")
    private String title;

    @Column(name="salary")
    private Double salary;

    // No args constructor
    public Employee(){

    }

    // All args constructor
    public Employee(long id, String name, String surName, int age, String email, String title, Double salary) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.email = email;
        this.title = title;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public Double getSalary() {
        return salary;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


}

