package BT1.src;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("001", "Laptop", 999.99);
        Product p2 = new Product("002", "Smartphone", 499.99);

        Customer c1 = new Customer("Tran Hoang Duy", "duyhoangtran2006@gmail.com", "Dong Nai");

        Order order = new Order("ORD1", c1);

        order.addItem(p1, 1);

        System.out.println("Order ORD1 was created!");

        OrderCalculator oc = new OrderCalculator();
        double total = oc.calculateTotal(order);
        System.out.println("Total: " + total);

        OrderRepository or = new OrderRepository();
        or.saveOrder(order);

        EmailService es = new EmailService();
        es.sendEmail(c1.email, "Your order " + order.orderId + " was created!");

    }
}
