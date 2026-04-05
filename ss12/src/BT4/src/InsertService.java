package BT4.src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class InsertService {

    public static void insertResults(List<TestResult> list) {
        String sql = "INSERT INTO Results(data) VALUES(?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (TestResult tr : list) {
                pstmt.setString(1, tr.getData());
                pstmt.addBatch();
            }

            pstmt.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}