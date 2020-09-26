package com.sda.jdbc;

import java.util.Set;

// POJO - Plain Old Java Object
// Classes that have private properties, public getters/setters, constructors
public class Department {

    private Integer departmentId;
    private String name;
    private Set<Employee> employees;

    public Department() {

    }

    public Department(Integer departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
