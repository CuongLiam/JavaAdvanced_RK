package BT3.src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class XuatVienService {

    public void xuatVienVaThanhToan(int maBenhNhan, double tienVienPhi) {
        Connection conn = null;

        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);

            String checkBalance = "SELECT balance FROM Patient_Wallet WHERE patient_id = ?";
            PreparedStatement psCheck = conn.prepareStatement(checkBalance);
            psCheck.setInt(1, maBenhNhan);
            ResultSet rs = psCheck.executeQuery();

            if (!rs.next()) {
                throw new Exception("Bệnh nhân không tồn tại");
            }

            double balance = rs.getDouble("balance");

            if (balance < tienVienPhi) {
                throw new Exception("Không đủ tiền");
            }

            String updateBalance = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(updateBalance);
            ps1.setDouble(1, tienVienPhi);
            ps1.setInt(2, maBenhNhan);
            int rows1 = ps1.executeUpdate();

            if (rows1 == 0) {
                throw new Exception("Update ví thất bại");
            }

            String updateBed = "UPDATE Beds SET status = 'available' WHERE patient_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(updateBed);
            ps2.setInt(1, maBenhNhan);
            int rows2 = ps2.executeUpdate();

            if (rows2 == 0) {
                throw new Exception("Update giường thất bại");
            }

            String updatePatient = "UPDATE Patients SET status = 'discharged' WHERE patient_id = ?";
            PreparedStatement ps3 = conn.prepareStatement(updatePatient);
            ps3.setInt(1, maBenhNhan);
            int rows3 = ps3.executeUpdate();

            if (rows3 == 0) {
                throw new Exception("Update bệnh nhân thất bại");
            }

            conn.commit();
            System.out.println("Xuất viện thành công");

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("Transaction fail: " + e.getMessage());

        } finally {
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}