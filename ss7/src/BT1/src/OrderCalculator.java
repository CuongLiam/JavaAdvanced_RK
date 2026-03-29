package BT1.src;

public class OrderCalculator {
    public double calculateTotal(Order order) {
        double sum = 0;
        for (OrderItem items : order.items) {
            sum += items.product.price * items.quantity;
        }
        return sum;
    }
}
