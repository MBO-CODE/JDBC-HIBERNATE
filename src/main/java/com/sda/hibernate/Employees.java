package com.sda.hibernate;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String firstname;
    private String lastname;
    private Date dateOfBirth;
    private String email;
    private Integer salary;
    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;
    @ManyToMany(fetch = FetchType.EAGER) // initializes the whole Project object and brings it from the start
    @JoinTable(
            name = "employees_projects",   // name of the intermediate table
            joinColumns = {@JoinColumn(name = "employeeId")},  // name of the column from the intermediate tabel that
            // references THIS entity
            inverseJoinColumns = {@JoinColumn(name = "projectId")}  // name of the column from the intermediate tabel that
            // references THE OTHER entity
    )
    private Set<Project> projects = new HashSet<>();

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                ", projects=" + projects +
                '}';
    }
}