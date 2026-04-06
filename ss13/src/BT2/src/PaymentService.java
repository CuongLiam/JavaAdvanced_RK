package BT2.src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentService {

    public void thanhToan(int patientId, int invoiceId, double amount) {
        Connection conn = null;

        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);

            try {
                String sql1 = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
                PreparedStatement ps1 = conn.prepareStatement(sql1);
                ps1.setDouble(1, amount);
                ps1.setInt(2, patientId);
                ps1.executeUpdate();
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException("Lỗi trừ tiền");
            }

            try {
                String sql2 = "UPDATE Invoices SET status = 'paid' WHERE invoice_id = ?";
                PreparedStatement ps2 = conn.prepareStatement(sql2);
                ps2.setInt(1, invoiceId);
                ps2.executeUpdate();
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException("Lỗi hóa đơn");
            }

            conn.commit();
            System.out.println("Thanh toán thành công");

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("Transaction fail");

        } finally {
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}