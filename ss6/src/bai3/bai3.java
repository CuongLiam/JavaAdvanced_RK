package bai3;

public class bai3 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("===== DEMO DEADLOCK =====");

        TicketPool roomA1 = new TicketPool("A", 5);
        TicketPool roomB1 = new TicketPool("B", 5);

        Thread d1 = new Thread(new BookingCounter("Quầy 1", roomA1, roomB1, false, false));
        Thread d2 = new Thread(new BookingCounter("Quầy 2", roomA1, roomB1, true, false));

        d1.start();
        d2.start();

        Thread.sleep(3000);

        System.out.println("\n===== FIX DEADLOCK =====");

        TicketPool roomA2 = new TicketPool("A", 5);
        TicketPool roomB2 = new TicketPool("B", 5);

        BookingCounter c1 = new BookingCounter("Quầy 1", roomA2, roomB2, false, true);
        BookingCounter c2 = new BookingCounter("Quầy 2", roomA2, roomB2, true, true);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Kết thúc chương trình");
        System.out.println("Quầy 1 bán: " + c1.getSoldCount());
        System.out.println("Quầy 2 bán: " + c2.getSoldCount());
        System.out.println("Còn A: " + roomA2.remaining());
        System.out.println("Còn B: " + roomB2.remaining());
    }
}
