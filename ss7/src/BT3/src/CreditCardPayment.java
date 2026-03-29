package BT3.src;

public class CreditCardPayment implements CardPayable {
    @Override
    public void processCard(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
