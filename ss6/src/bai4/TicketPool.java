package bai4;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {
    private final String roomName;
    private final List<Ticket> tickets;

    public TicketPool(String roomName, int totalTickets) {
        this.roomName = roomName;
        this.tickets = new ArrayList<>();
        for (int i = 1; i <= totalTickets; i++) {
            String ticketId = String.format("%s-%03d", roomName, i);
            tickets.add(new Ticket(ticketId, roomName));
        }
    }

    public String getRoomName() {
        return roomName;
    }

    public synchronized Ticket sellTicket() {
        for (Ticket ticket : tickets) {
            if (!ticket.isSold()) {
                ticket.markSold();
                return ticket;
            }
        }
        return null;
    }

    public synchronized int remainingTickets() {
        int count = 0;
        for (Ticket ticket : tickets) {
            if (!ticket.isSold()) {
                count++;
            }
        }
        return count;
    }
}
