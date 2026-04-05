package BT2.src;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class VitalsDAO {

    public boolean updateVitals(int patientId, double temp, int heartRate) {
        String sql = "UPDATE Vitals SET temperature=?, heart_rate=? WHERE p_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, temp);
            ps.setInt(2, heartRate);
            ps.setInt(3, patientId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}