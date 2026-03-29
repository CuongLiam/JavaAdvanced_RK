package BT4.src;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOrderRepository implements OrderRepository {
    @Override
    public void save(Order order) {
        System.out.println("Save order to database: " + order.id);
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>();
    }
}
