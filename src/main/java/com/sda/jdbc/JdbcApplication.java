package com.sda.jdbc;

import java.sql.*;

public class JdbcApplication {

    public static void main(String[] args) throws SQLException {
        DepartmentRepository dr = new DepartmentRepository();

        Department newDepartment = new Department();
        newDepartment.setName("new department");

        dr.save(newDepartment);
    }
}
