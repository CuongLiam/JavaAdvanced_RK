package bai1;

import java.util.Queue;
import java.util.LinkedList;

public class TicketPool {
    private Queue<Ticket> tickets = new LinkedList<>();
    private String prefix;
    private int counter = 1;

    public synchronized void addTicket(int count) {
        for (int i = 0; i < count; i++) {
            String id = prefix + counter;
            counter++;
            tickets.add(new Ticket(id));
        }
    }

    public TicketPool(String prefix, int initial) {
        this.prefix = prefix;
        addTicket(initial);
    }

    public synchronized Ticket sellTicket() {
        if (tickets == null || tickets.isEmpty()) {
            return null;
        }
        return tickets.poll();
    }

    public synchronized int getRemainingTickets() {
        return tickets.size();
    }
}
