package BT4.src;

public class OrderService {
    private OrderRepository orderRepository;
    private NotificationService notificationService;

    public OrderService(OrderRepository orderRepository, NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
    }

    public void createOrder(String id) {
        Order order = new Order(id);

        orderRepository.save(order);
        notificationService.send("Order created", order.id);
    }
}
