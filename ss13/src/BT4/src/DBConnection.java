package BT4.src;

import java.sql.Connection;
import java.sql.DriverManager;

class DBConnection {
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                "password"
        );
    }
}