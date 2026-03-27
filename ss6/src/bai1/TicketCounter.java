package bai1;

public class TicketCounter implements Runnable {
    private final String name;
    private final TicketPool ticketPool;
    private final TicketSupplier supplier;
    private int sold = 0;

    public TicketCounter(String name, TicketPool ticketPool, TicketSupplier supplier) {
        this.name = name;
        this.ticketPool = ticketPool;
        this.supplier = supplier;
    }

    public int getSold() {
        return sold;
    }

    @Override
    public void run() {
        while (!supplier.done || ticketPool.getRemainingTickets() > 0) {
            Ticket t = ticketPool.sellTicket();
            if (t != null) {
                System.out.println(name + " sold ticket " + t.getId());
                sold++;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}