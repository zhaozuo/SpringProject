package test;

import java.sql.*;

public class Jdbc {
    public static void main(String[] args) {
        String JDBC_URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "123456";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM test_info WHERE name=?")) {
                ps.setObject(1, "王兆祚");
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String name = rs.getString("name");
                        String sex = rs.getString("sex");
                        System.out.println(name + ", " + sex);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
