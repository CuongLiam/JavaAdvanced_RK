package BT1.src;

import java.sql.*;

public class MedicineService {

    public void updateMedicine(int medicineId, int patientId) {
        Connection conn = null;

        try {
            conn = DBConnection.getConnection();

            conn.setAutoCommit(false);

            String sql1 = "UPDATE medicine_inventory SET quantity = quantity - 1 WHERE medicine_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1, medicineId);
            ps1.executeUpdate();

            String sql2 = "INSERT INTO prescription_log(patient_id, medicine_id) VALUES (?, ?)";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, patientId);
            ps2.setInt(2, medicineId);
            ps2.executeUpdate();

            conn.commit();
            System.out.println("Transaction thành công");

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
                System.out.println("Rollback do lỗi");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();

        } finally {
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}