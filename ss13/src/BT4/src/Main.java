package BT4.src;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BenhNhanService service = new BenhNhanService();
        List<BenhNhanDTO> result = service.getAll();
        System.out.println(result);
    }
}