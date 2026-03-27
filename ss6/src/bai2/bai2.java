package bai2;

public class bai2 {
    public static void main(String[] args) throws InterruptedException {
        TicketPool roomA = new TicketPool("Room A", 100);
        TicketPool roomB = new TicketPool("Room B", 100);

        BookingCounter counter1 = new BookingCounter("Counter 1", roomA, roomB);
        BookingCounter counter2 = new BookingCounter("Counter 2", roomA, roomB);

        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Room A sold: " + counter1.getSoldCount());
        System.out.println("Room B sold: " + counter2.getSoldCount());

        System.out.println("Room A remaining: " + roomA.remaining());
        System.out.println("Room B remaining: " + roomB.remaining());

        System.out.println("Total sold: " + (counter1.getSoldCount() + counter2.getSoldCount()));
    }
}
