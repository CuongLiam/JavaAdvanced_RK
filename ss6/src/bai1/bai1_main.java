package bai1;

public class bai1_main {
    public static void main(String[] args) throws InterruptedException {
        TicketPool roomA = new TicketPool("A-", 10);
        TicketPool roomB = new TicketPool("B-", 10);

        TicketSupplier supplier = new TicketSupplier(roomA, roomB, 5, 2000, 5);
        TicketCounter counter1 = new TicketCounter("Counter 1", roomA, supplier);
        TicketCounter counter2 = new TicketCounter("Counter 2", roomB, supplier);

        Thread supplierThread = new Thread(supplier);
        supplierThread.start();

        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);
        Thread t3 = new Thread(supplier);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final tickets sold by Counter1: " + counter1.getSold());
        System.out.println("Final tickets sold by Counter2: " + counter2.getSold());

        System.out.println("Remaining tickets in Room A: " + roomA.getRemainingTickets());
        System.out.println("Remaining tickets in Room B: " + roomB.getRemainingTickets());
    }

}