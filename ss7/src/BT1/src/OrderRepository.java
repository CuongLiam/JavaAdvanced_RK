package BT1.src;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private List<Order> db = new ArrayList<>();

    public void saveOrder(Order order) {
        db.add(order);
        System.out.println("Order saved successfully!");
    }
}

