public class inClass {
    public static void main() {
        Logger logger = Logger.getInstance();

        BillFactory factory = new DineInBillFactory();
        factory.proccessBill();

        factory = new DineInBillFactory();
        factory.proccessBill();

    }

    // ví dụ minh hoạ

    // 1:
    // singleton pattern


    static class Logger{
        // 1. Biến private static thể hiện instance duy nhất
        private static Logger instance;


        // 2. private constructor
        private Logger(){
            System.out.println("Logger: thể hiện kết nối file duy nhất (constructor)");
        }

        // 3. phương thức static public để lấy thể hiện
        public static Logger getInstance(){
            if (instance == null){
                instance = new Logger();
            }
            return instance;
        }

        public void log(String msg){
            System.out.println("LOG: "+msg);
            // ...
        }
    }

    // 2:
    // Factory method
    private interface Bill{
        void calculateTotal();
        void print();
    }

    // concrete product: Các hoá đơn cụ thể
    static class DineInBill implements Bill{
        @Override
        public void calculateTotal() {
            System.out.println("calculate total....");
        }
        @Override
        public void print() {
            System.out.println("in hoá đơn ăn tại chỗ");
        }
    }
    static class TakeawayBill implements Bill{
        @Override
        public void calculateTotal() {
            System.out.println("takeaway total: ");
        }

        @Override
        public void print() {
            System.out.println("In hoá đơn mang về");
        }
    }
    static class DiliveryBill implements Bill{
        @Override
        public void calculateTotal() {
            System.out.println("DiliveryBill: ");
        }

        @Override
        public void print() {
            System.out.println("in hoá đơn giao hàng");
        }
    }

    // Creator: abstract class BillFactory
    abstract static class BillFactory{
        // Factory method - để các lớp con implement

        abstract Bill createBill();

        // method dùng chung cho mọi loại bill:
        public void proccessBill(){
            Bill bill = createBill();

            bill.calculateTotal();
            bill.print();
            // dùng singleton logger để ghi log
            Logger.getInstance().log("Đã xử lý 1 hoá đơn");
        }
    }

    // Concrete Creators: Các factory cụ thể cho từng loại bill
    static class DineInBillFactory extends BillFactory{
        @Override
        Bill createBill() {
            return new DineInBill();
        }
    }
    static class TakeawayBillFactory extends BillFactory{
        @Override
        Bill createBill() {
            return new TakeawayBill();
        }
    }
    static class diliveryBillFactory extends BillFactory{
        @Override
        Bill createBill() {
            return new DiliveryBill();
        }
    }


    // Giải quyết vấn đề: Hệ thống vận hành trơn tru

    // Logger giờ đây là duy nhất. Dù ở bất kỳ đâu, khi gọi Logger.getInstance(),
    // ta đều nhận về cùng một đối tượng. Không còn xung đột file log nữa.

    // Việc tạo hóa đơn trở nên trong sáng. Khi cần tạo loại hóa đơn nào,
    // ta chỉ việc dùng factory tương ứng. Nếu có loại hóa đơn mới (ví dụ VipBill),
    // ta chỉ cần tạo class VipBill và VipBillFactory mà không hề động đến code cũ.


}
