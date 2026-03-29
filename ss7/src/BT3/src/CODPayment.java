package BT3.src;

public class CODPayment implements CODPayable {
    @Override
    public void processCOD(double amount) {
        System.out.println("Processing COD payment of $" + amount);
    }
}
