package bai2;

import java.util.Random;

public class BookingCounter implements Runnable {
    private final String counterName;
    private final TicketPool roomA;
    private TicketPool roomB;
    private int soldCount = 0;
    private final Random random = new Random();

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    public int getSoldCount() {
        return soldCount;
    }

    @Override
    public void run() {
        while (true) {
            if (roomA.remaining() == 0 && roomB.remaining() == 0) {
                break;
            }
            Ticket t = null;

            if (random.nextBoolean()) {
                t = roomA.sellTicket();
                if (t == null) t = roomB.sellTicket();
            } else {
                t = roomB.sellTicket();
                if (t == null) t = roomA.sellTicket();
            }
            if (t != null) {
                System.out.println(counterName + " sold ticket: " + t.getTicketId());
                soldCount++;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
