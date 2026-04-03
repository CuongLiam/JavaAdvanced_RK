package BT3.src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BedService {
    public static void updateBedStatus(int bedId, String status) {
        String sql = "UPDATE Beds SET bed_status = ? WHERE bed_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, status);
            stmt.setInt(2, bedId);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Bed status updated successfully.");
            } else {
                System.out.println("No bed found with the given ID.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
