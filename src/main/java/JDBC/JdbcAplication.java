package JDBC;

import java.sql.*;

public class JdbcAplication {

    public static void main(String[] args) throws SQLException {


        Connection conn = DriverManager.getConnection(
                DatabaseUtils.DATABASE_HOST,
                DatabaseUtils.DATABASE_USERNAME,
                DatabaseUtils.DATABASE_PASSWORD);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM departments");

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
