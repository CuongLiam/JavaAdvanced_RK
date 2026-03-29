package BT3.src;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        PaymentMethod cod = new CODPayment();
        paymentProcessor.processPayment(cod, 200.0);

        PaymentMethod card = new CreditCardPayment();
        paymentProcessor.processPayment(card, 300.0);

        PaymentMethod momo = new MomoPayment();
        paymentProcessor.processPayment(momo, 400.0);


        PaymentMethod test = new CODPayment();
        paymentProcessor.processPayment(test, 500.0);

        test = new CreditCardPayment();
        paymentProcessor.processPayment(test, 600.0);
    }
}
