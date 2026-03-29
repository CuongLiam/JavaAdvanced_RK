package BT4.src;

import java.util.ArrayList;
import java.util.List;

public class FileOrderRepository implements OrderRepository {
    @Override
    public void save(Order order) {
        System.out.println("Save order to file: " + order.id);
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>();
    }
}
