package bai3;

import java.util.*;

public class TicketPool {
    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int count) {
        this.roomName = roomName;
        for (int i = 1; i <= count; i++) {
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", i), roomName));
        }
    }

    public Ticket getUnsoldTicket() {
        for (Ticket t : tickets) {
            if (!t.isSold()) {
                t.setSold(true);
                return t;
            }
        }
        return null;
    }

    public void returnTicket(Ticket t) {
        if (t != null) t.setSold(false);
    }

    public int remaining() {
        int c = 0;
        for (Ticket t : tickets) {
            if (!t.isSold()) c++;
        }
        return c;
    }
}
