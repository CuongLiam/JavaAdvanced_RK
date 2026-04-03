package BT4.src;

import java.sql.*;

public class PatientService {

    private static final String DB_URL = "jdbc:sqlite:patients.db"; // Assuming SQLite, change as needed

    public static void findPatientByName(String name) {
        String sql = "SELECT * FROM Patients WHERE full_name = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);

            try (ResultSet rs = pstmt.executeQuery()) {
                boolean found = false;

                while (rs.next()) {
                    found = true;
                    System.out.println("ID: " + rs.getInt("id")
                            + " | Name: " + rs.getString("full_name"));
                }

                if (!found) {
                    System.out.println("Không tìm thấy bệnh nhân!");
                }
            }

        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
