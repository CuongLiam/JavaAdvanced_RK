package BT2.src;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT medicine_name, stock FROM Pharmacy");
            System.out.println("=== DANH SÁCH THUỐC ===");
            while (rs.next()) {
                String name = rs.getString("medicine_name");
                int stock = rs.getInt("stock");
                System.out.println("Thuốc: " + name + " | Tồn kho: " + stock);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                DBContext.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
