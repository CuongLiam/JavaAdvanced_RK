package BT1.src;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBContext {
        private static final String url  = "jbdc:mysql://192.168.1.10:3306/Hospital_DB";
        private static final String user = "admin";
        private static final String password = "med123";

        public static Connection connection() throws SQLException {
                return DriverManager.getConnection(url, user, password);
        }

        public static void close(Connection connection) {
                try {
                        if (connection != null && !connection.isClosed()) {
                                connection.close();
                        }
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                finally {
                        DBContext.close(connection);
                }
        }
}