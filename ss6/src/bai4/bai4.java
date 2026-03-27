package bai4;

public class bai4 {
    public static void main(String[] args) {
        TicketPool roomA = new TicketPool("A", 10);
        TicketPool roomB = new TicketPool("B", 10);

        BookingCounter counter1 = new BookingCounter("Quay 1", roomA, roomB);
        BookingCounter counter2 = new BookingCounter("Quay 2", roomA, roomB);

        Thread thread1 = new Thread(counter1);
        Thread thread2 = new Thread(counter2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread bi gian doan.");
        }

        System.out.println("\nKet thuc chuong trinh");
        System.out.println(counter1.getCounterName() + " ban duoc: " + counter1.getSoldCount() + " ve");
        System.out.println(counter2.getCounterName() + " ban duoc: " + counter2.getSoldCount() + " ve");
        System.out.println("Ve con lai phong A: " + roomA.remainingTickets());
        System.out.println("Ve con lai phong B: " + roomB.remainingTickets());
    }

}
