package BT1.src;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
   public static Connection getConnection() throws Exception {
       String url = "jdbc:mysql://localhost:3306/testdb";
       String user = "root";
       String password = "";
       return DriverManager.getConnection(url, user, password);
   }
}