package com.sda.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class EmployeeRepository {

    public Employees findById(Integer employeeId) {
        //Opening a way of communication with the database
        Session session = HibernateUtils.getSessionFactory().openSession();        //Retrieving the employee with the id 1
        Employees dept = session.find(Employees.class, employeeId);        //Closing the communication with the database
        session.close();
        return dept;
    }

    public List<Employees> findByDepartmentName(String departmentName) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query selectEmployeeByDepartment = session.createQuery("from Employees e WHERE e.department.name = '" + departmentName + "'");
        List<Employees> employees = selectEmployeeByDepartment.list();
        session.close();
        return employees;
    }

    public Set<Employees> findAll() {
        return null;
    }

    public Employees findByName(String employeeName) {
        return null;
    }

    public void save(Employees employee) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }

    public void update(Employees employee) {
    }

    public void deleteById(Integer employeeId) {
    }
}