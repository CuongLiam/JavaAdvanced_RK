package BT3.src;

public interface CODPayable extends PaymentMethod {
    void processCOD(double amount);
}
