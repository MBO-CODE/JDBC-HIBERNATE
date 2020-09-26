package com.sda.jdbc;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class DepartmentRepository {

    public Set<Department> findAll() throws SQLException {
        // Initializing the empty set that will be populated with the results from the database
        Set<Department> departments = new HashSet<>();

        // The connection object opens a tunnel to the database
        // Through which we will execute SQL queries
        Connection conn = DriverManager.getConnection(
                DatabaseUtils.DATABASE_HOST,
                DatabaseUtils.DATABASE_USERNAME,
                DatabaseUtils.DATABASE_PASSWORD);

        // The createStatement() allows us the initialize a SQL query
        // Which we will then be able to run
        Statement stmt = conn.createStatement();

        // The executeQuery() method allows us to execute a SQL query
        ResultSet rs = stmt.executeQuery("SELECT * FROM departments");


        // Iterate all rows from the result
        while (rs.next()) {
            // Extract the data from the particular columns
            Integer deptId = rs.getInt("departmentId");
            String deptName = rs.getString("name");

            // Initializing a department with the data from the returned row
            // And adding it to the set
            Department d = new Department(deptId, deptName);

            departments.add(d);
        }

        // Closing the database objects
        rs.close();
        stmt.close();
        conn.close();

        // Returning the set with all the departments from the database
        return departments;
    }

    public Department findById(Integer departmentId) throws SQLException {
        Department department = new Department();

        // The connection object opens a tunnel to the database
        // Through which we will execute SQL queries
        Connection conn = DriverManager.getConnection(
                DatabaseUtils.DATABASE_HOST,
                DatabaseUtils.DATABASE_USERNAME,
                DatabaseUtils.DATABASE_PASSWORD);

        // The createStatement() allows us the initialize a SQL query
        // Which we will then be able to run
        Statement stmt = conn.createStatement();

        // The executeQuery() method allows us to execute a SQL query
        ResultSet rs = stmt.executeQuery("SELECT * FROM departments WHERE departmentId = " + departmentId);

        // Iterate all rows from the result
        while (rs.next()) {
            // Extract the data from the particular columns
            Integer deptId = rs.getInt("departmentId");
            String deptName = rs.getString("name");

            department.setDepartmentId(deptId);
            department.setName(deptName);
        }

        rs.close();
        stmt.close();
        conn.close();

        return department;
    }

    public void save(Department department) throws SQLException {
        // The connection object opens a tunnel to the database
        // Through which we will execute SQL queries
        Connection conn = DriverManager.getConnection(
                DatabaseUtils.DATABASE_HOST,
                DatabaseUtils.DATABASE_USERNAME,
                DatabaseUtils.DATABASE_PASSWORD);

        // The createStatement() allows us the initialize a SQL query
        // Which we will then be able to run
        Statement stmt = conn.createStatement();

        // Instead of executeQuery use executeUpdate for INSERT/UPDATE/DELETE
        stmt.executeUpdate("INSERT INTO departments (name) VALUES ('" + department.getName() + "')");

        stmt.close();
        conn.close();
    }
    
    public void update(Department department) throws SQLException {
        Connection conn = DriverManager.getConnection(
                DatabaseUtils.DATABASE_HOST,
                DatabaseUtils.DATABASE_USERNAME,
                DatabaseUtils.DATABASE_PASSWORD);

        Statement stmt = conn.createStatement();

        stmt.executeUpdate("UPDATE departments SET name = '" + department.getName() + "' " +
                "WHERE departmentId =" + department.getDepartmentId());
        stmt.close();
        conn.close();
    }
}
