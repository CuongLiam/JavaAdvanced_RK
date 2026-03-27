package bai1;

public class TicketSupplier implements Runnable {
    private TicketPool roomA, roomB;
    private int supplyCount;
    private int interval;
    private int rounds;
    public volatile boolean done = false;

    public TicketSupplier(TicketPool roomA, TicketPool roomB, int supplyCount, int interval, int rounds) {
        this.roomA = roomA;
        this.roomB = roomB;
        this.supplyCount = supplyCount;
        this.interval = interval;
        this.rounds = rounds;
    }

    @Override
    public void run() {
        for (int i = 0; i < rounds; i++) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            roomA.addTicket(supplyCount);
            roomB.addTicket(supplyCount);

            System.out.println("Supplier added " + supplyCount + " tickets to both rooms");
        }
        done = true;
    }
}
