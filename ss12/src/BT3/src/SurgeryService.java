package BT3.src;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.concurrent.Callable;

public class SurgeryService {
    public static double getSurgeryFee(int surgeryId) {
        double cost = 0;

        try (Connection conn = DBConnection.getConnection()) {
            CallableStatement csmt = conn.prepareCall("{call GET_SURGERY_FEE(?, ?)}");

            csmt.setInt(1, surgeryId);

            csmt.registerOutParameter(2, Types.DECIMAL);

            csmt.execute();

            cost = csmt.getDouble(2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cost;
    }
}
