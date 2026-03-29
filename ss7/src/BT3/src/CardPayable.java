package BT3.src;

public interface CardPayable extends PaymentMethod {
    void processCard(double amount);
}
