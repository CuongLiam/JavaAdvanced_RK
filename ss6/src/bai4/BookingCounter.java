package bai4;

import java.util.Random;

public class BookingCounter implements Runnable {
    private final String counterName;
    private final TicketPool roomA;
    private final TicketPool roomB;
    private int soldCount;
    private final Random random;

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
        this.soldCount = 0;
        this.random = new Random();
    }

    public int getSoldCount() {
        return soldCount;
    }

    public String getCounterName() {
        return counterName;
    }

    @Override
    public void run() {
        while (roomA.remainingTickets() > 0 || roomB.remainingTickets() > 0) {
            TicketPool selectedRoom = random.nextBoolean() ? roomA : roomB;
            Ticket soldTicket = selectedRoom.sellTicket();

            if (soldTicket == null) {
                selectedRoom = selectedRoom == roomA ? roomB : roomA;
                soldTicket = selectedRoom.sellTicket();
            }

            if (soldTicket != null) {
                soldCount++;
                System.out.println(counterName + " ban ve phong " + soldTicket.getRoomName());
                System.out.println(counterName + " da ban ve " + soldTicket.getTicketId());
            }
        }
    }
}
