package com.er.entity;

public class Employee {
    public int id;
    public String ename;

    public Employee(String ename) {
        this.ename = ename;
    }

    public int getId() {
        return id;
    }

    public Employee(int id, String ename) {
        this.id = id;
        this.ename = ename;
    }

    public Employee() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                '}';
    }
}
