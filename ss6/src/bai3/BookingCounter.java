package bai3;

public class BookingCounter implements Runnable {
    private String name;
    private TicketPool roomA, roomB;
    private boolean reverseOrder;
    private boolean safeMode;
    private int soldCount = 0;

    public BookingCounter(String name, TicketPool A, TicketPool B,
                          boolean reverseOrder, boolean safeMode) {
        this.name = name;
        this.roomA = A;
        this.roomB = B;
        this.reverseOrder = reverseOrder;
        this.safeMode = safeMode;
    }

    public int getSoldCount() { return soldCount; }

    @Override
    public void run() {
        while (true) {
            if (roomA.remaining() == 0 || roomB.remaining() == 0) break;

            boolean success;
            if (safeMode) {
                success = sellComboSafe();
            } else {
                success = sellComboDeadlock();
            }

            sleep(200);
        }
    }

    // ================= DEADLOCK =================
    private boolean sellComboDeadlock() {
        Ticket tA = null, tB = null;

        if (!reverseOrder) {
            synchronized (roomA) {
                System.out.println(name + ": giữ A");
                sleep(100);

                synchronized (roomB) {
                    System.out.println(name + ": chờ B");
                    tA = roomA.getUnsoldTicket();
                    tB = roomB.getUnsoldTicket();
                }
            }
        } else {
            synchronized (roomB) {
                System.out.println(name + ": giữ B");
                sleep(100);

                synchronized (roomA) {
                    System.out.println(name + ": chờ A");
                    tA = roomA.getUnsoldTicket();
                    tB = roomB.getUnsoldTicket();
                }
            }
        }

        if (tA != null && tB != null) {
            System.out.println(name + " bán combo: "
                    + tA.getTicketId() + " & " + tB.getTicketId());
            soldCount++;
            return true;
        } else {
            roomA.returnTicket(tA);
            roomB.returnTicket(tB);
            return false;
        }
    }

    // ================= FIX DEADLOCK =================
    private boolean sellComboSafe() {
        Ticket tA = null, tB = null;

        synchronized (roomA) {          // luôn A trước
            synchronized (roomB) {      // rồi B

                tA = roomA.getUnsoldTicket();
                tB = roomB.getUnsoldTicket();

                if (tA != null && tB != null) {
                    System.out.println(name + " bán combo: "
                            + tA.getTicketId() + " & " + tB.getTicketId());
                    soldCount++;
                    return true;
                } else {
                    roomA.returnTicket(tA);
                    roomB.returnTicket(tB);
                    System.out.println(name + ": combo thất bại");
                    return false;
                }
            }
        }
    }

    private void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }
}
