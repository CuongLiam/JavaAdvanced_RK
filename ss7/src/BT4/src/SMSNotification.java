package BT4.src;

public class SMSNotification implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Send SMS to: " + recipient + " with message: " + message);
    }
}
