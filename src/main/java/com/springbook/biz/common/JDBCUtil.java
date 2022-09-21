package com.springbook.biz.common;

import java.sql.*;

public class JDBCUtil {
    public static Connection getConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mariadb://localhost:3306/test",
                    "buddy",
                    "");
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
