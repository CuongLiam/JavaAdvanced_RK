package bai2;

public class Ticket {
    private final String ticketId;
    private final String roomName;
    private boolean isSold;

    public Ticket(String ticketId, String roomName, boolean isSold) {
        this.ticketId = ticketId;
        this.roomName = roomName;
        this.isSold = isSold;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }
}
