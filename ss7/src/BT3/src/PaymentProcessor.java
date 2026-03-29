package BT3.src;

public class PaymentProcessor {
    public void processPayment(PaymentMethod paymentMethod, double amount) {
        if (paymentMethod instanceof CODPayable) {
            ((CODPayable) paymentMethod).processCOD(amount);
        }
        else if (paymentMethod instanceof CardPayable) {
            ((CardPayable) paymentMethod).processCard(amount);
        }
        else if (paymentMethod instanceof EWalletPayable) {
            ((EWalletPayable) paymentMethod).processMomo(amount);
        }
        else {
            throw new IllegalArgumentException("Invalid payment method!");
        }
    }
}
