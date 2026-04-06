package BT4.src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BenhNhanService {

    public List<BenhNhanDTO> getAll() {
        List<BenhNhanDTO> result = new ArrayList<>();
        Map<Integer, BenhNhanDTO> map = new HashMap<>();

        String sql = "SELECT b.maBenhNhan, b.ten, d.id as dv_id, d.tenDichVu " +
                "FROM BenhNhan b " +
                "LEFT JOIN DichVuSuDung d ON b.maBenhNhan = d.maBenhNhan";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("maBenhNhan");

                BenhNhanDTO bn = map.get(id);
                if (bn == null) {
                    bn = new BenhNhanDTO();
                    bn.maBenhNhan = id;
                    bn.ten = rs.getString("ten");
                    map.put(id, bn);
                }

                int dvId = rs.getInt("dv_id");
                if (!rs.wasNull()) {
                    DichVu dv = new DichVu();
                    dv.id = dvId;
                    dv.tenDichVu = rs.getString("tenDichVu");
                    bn.dsDichVu.add(dv);
                }
            }

            result.addAll(map.values());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}