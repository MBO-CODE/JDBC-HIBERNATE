package JDBC;

import java.sql.*;

public class DepartmentRepository {

    public void findById(Integer departmentId) throws SQLException {
        Connection conn = DriverManager.getConnection(
                DatabaseUtils.DATABASE_HOST,
                DatabaseUtils.DATABASE_USERNAME,
                DatabaseUtils.DATABASE_PASSWORD);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM departments WHERE departmentId = " + departmentId);

        while (rs.next()) {
            Integer deptId = rs.getInt("departmentId");
            String deptName = rs.getString("name");
            System.out.println(deptId + " " + deptName);
        }
        rs.close();
        stmt.close();
        conn.close();

    }
}
