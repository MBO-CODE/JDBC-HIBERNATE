package com.sda.hibernate;

import com.sda.jdbc.Employee;
import org.hibernate.Session;

import java.util.List;

public class HibernateApplication {
    public static void main(String[] args) {

        //Opening a way of communication with the database
        Session session = HibernateUtils.getSessionFactory().openSession();        //Retrieving the department with the id 1
        Department dept1 = session.find(Department.class, 1);
        Department dept2 = session.find(Department.class, 2);
        System.out.println(dept1);
        System.out.println(dept2);        //Closing the communication with the database
        session.close();

//
//        DepartmentRepository dr = new DepartmentRepository();
//        System.out.println(dr.findById(3));
//
//        Department hibernateDep = new Department();
//        hibernateDep.setName("My new hibernate department");
//        dr.saveD(hibernateDep);

        EmployeeRepository employeeRepository = new EmployeeRepository();
        System.out.println(employeeRepository.findById(3));

        DepartmentRepository departmentRepository = new DepartmentRepository();
        List<Department> departmentList = departmentRepository.findAll();

        for(Department d : departmentList) {
            System.out.println(d);
        }

        List<Department> departmentByNameList = departmentRepository.findByName("CyberSecurity");

        for(Department d : departmentByNameList) {
            System.out.println(d);
        }

        List<Employees> employeesList = employeeRepository.findByDepartmentName("HR");
        for (Employees e : employeesList) {
            System.out.println(e);
        }


    }
}
