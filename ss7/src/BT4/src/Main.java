package BT4.src;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService(new DatabaseOrderRepository(), new EmailService());
        orderService.createOrder("ORD1");

        OrderService orderService2 = new OrderService(new FileOrderRepository(), new SMSNotification());
        orderService2.createOrder("ORD2");
    }
}
