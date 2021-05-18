package com.sunny.enterprise.target.model;

public class User {
    Long id;
    String name;
    Long salary;
    Integer age;

    public User()
    {

    }

    public User(Long id, String name, Long salary, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.address = address;
    }

    String address;

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
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
