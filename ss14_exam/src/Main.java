import java.sql.*;
import java.util.Scanner;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/SS14_EXAM";
    private static final String USER = "root";
    private static final String PASSWORD = "CuongQiqi3000~";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap AccountId nguoi gui: ");
        String senderId = scanner.nextLine().trim();

        System.out.print("Nhap AccountId nguoi nhan: ");
        String receiverId = scanner.nextLine().trim();

        System.out.print("Nhap so tien chuyen: ");
        double amount = scanner.nextDouble();

        // try-with-resources đảm bảo đóng tài nguyên đúng cách
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            // Tắt auto-commit để quản lý Transaction thủ công
            conn.setAutoCommit(false);

            try {
                // ===== 1. Kiểm tra tài khoản người gửi tồn tại và đủ số dư (PreparedStatement) =====
                String checkQuery = "SELECT Balance FROM Accounts WHERE AccountId = ?";
                try (PreparedStatement psCheck = conn.prepareStatement(checkQuery)) {
                    psCheck.setString(1, senderId);
                    try (ResultSet rs = psCheck.executeQuery()) {
                        if (!rs.next()) {
                            System.out.println("Loi: Tai khoan nguoi gui " + senderId + " khong ton tai!");
                            conn.rollback();
                            return;
                        }
                        double senderBalance = rs.getDouble("Balance");
                        if (senderBalance < amount) {
                            System.out.println("Loi: So du tai khoan " + senderId + " khong du! (Hien co: " + senderBalance + ")");
                            conn.rollback();
                            return;
                        }
                    }
                }

                // Kiểm tra tài khoản người nhận tồn tại
                try (PreparedStatement psCheck = conn.prepareStatement(checkQuery)) {
                    psCheck.setString(1, receiverId);
                    try (ResultSet rs = psCheck.executeQuery()) {
                        if (!rs.next()) {
                            System.out.println("Loi: Tai khoan nguoi nhan " + receiverId + " khong ton tai!");
                            conn.rollback();
                            return;
                        }
                    }
                }

                // ===== 2. Gọi Stored Procedure bằng CallableStatement =====
                String callProc = "{CALL sp_UpdateBalance(?, ?)}";

                // Lần 1: Trừ tiền tài khoản người gửi (amount âm)
                try (CallableStatement csTru = conn.prepareCall(callProc)) {
                    csTru.setString(1, senderId);
                    csTru.setBigDecimal(2, java.math.BigDecimal.valueOf(-amount));
                    csTru.execute();
                }

                // Lần 2: Cộng tiền tài khoản người nhận (amount dương)
                try (CallableStatement csCong = conn.prepareCall(callProc)) {
                    csCong.setString(1, receiverId);
                    csCong.setBigDecimal(2, java.math.BigDecimal.valueOf(amount));
                    csCong.execute();
                }

                // ===== 3. Commit Transaction =====
                conn.commit();
                System.out.println("Chuyen khoan thanh cong!");

                // ===== 4. Hiển thị kết quả đối soát bằng PreparedStatement =====
                String selectQuery = "SELECT AccountId, FullName, Balance FROM Accounts WHERE AccountId IN (?, ?)";
                try (PreparedStatement psResult = conn.prepareStatement(selectQuery)) {
                    psResult.setString(1, senderId);
                    psResult.setString(2, receiverId);
                    try (ResultSet rs = psResult.executeQuery()) {
                        System.out.println("+-----------+--------------------+--------------+");
                        System.out.println("| AccountId | FullName           | Balance      |");
                        System.out.println("+-----------+--------------------+--------------+");
                        while (rs.next()) {
                            System.out.printf("| %-9s | %-18s | %12.2f |%n",
                                    rs.getString("AccountId"),
                                    rs.getString("FullName"),
                                    rs.getDouble("Balance"));
                        }
                        System.out.println("+-----------+--------------------+--------------+");
                    }
                }

            } catch (SQLException e) {
                // Rollback toàn bộ nếu có lỗi SQL
                System.out.println("Loi trong qua trinh chuyen khoan: " + e.getMessage());
                conn.rollback();
            }

        } catch (SQLException e) {
            System.out.println("Loi ket noi CSDL: " + e.getMessage());
        }
    }
}