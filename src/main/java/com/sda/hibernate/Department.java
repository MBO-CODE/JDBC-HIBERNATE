package com.sda.hibernate;


import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;


// POJO - Plain Old Java Object
// Classes that have private properties, public getters/setters, constructors
//Hibernate Annotation
@Entity
@Table(name = "departments") //optional if table name is the same. Practic,daca numele clasei e diferit,atucni se pune

public class Department {

    @Id  // marks the property as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // marks the primary key as AUTO INCREMENTED
    private Integer departmentId;
    @Column(name = "name")  // optional if column name is the same
    private String name;
    @OneToMany(mappedBy = "department")
    private Set<Employees> employees = new HashSet<>();

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

    public Set<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employees> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", name='" + name + '\'' +
                '}';
    }

}
