import java.util.*;





// ===== Main Program =====
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Device> devices = new ArrayList<>();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Kết nối phần cứng");
            System.out.println("2. Tạo thiết bị");
            System.out.println("3. Bật thiết bị");
            System.out.println("4. Tắt thiết bị");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    HardwareConnection.getInstance();
                    break;

                case 2:
                    System.out.println("Chọn loại: 1. Đèn  2. Quạt  3. Điều hòa");
                    int type = sc.nextInt();
                    DeviceFactory factory = null;

                    if (type == 1) factory = new LightFactory();
                    else if (type == 2) factory = new FanFactory();
                    else if (type == 3) factory = new AirConditionerFactory();

                    if (factory != null) {
                        devices.add(factory.createDevice());
                    }
                    break;

                case 3:
                    if (devices.isEmpty()) {
                        System.out.println("Chưa có thiết bị.");
                        break;
                    }
                    System.out.print("Chọn thiết bị: ");
                    int i = sc.nextInt() - 1;
                    if (i >= 0 && i < devices.size())
                        devices.get(i).turnOn();
                    break;

                case 4:
                    if (devices.isEmpty()) {
                        System.out.println("Chưa có thiết bị.");
                        break;
                    }
                    System.out.print("Chọn thiết bị: ");
                    int j = sc.nextInt() - 1;
                    if (j >= 0 && j < devices.size())
                        devices.get(j).turnOff();
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
            }
        }
    }
}