package BT3.src;

public class MomoPayment implements EWalletPayable {
    @Override
    public void processMomo(double amount) {
        System.out.println("Processing momo payment of $" + amount);
    }
}
