package BT3.src;

public class Main {
    public static void main(String[] args) {
        int surgeryId = 505;
        double cost = SurgeryService.getSurgeryFee(surgeryId);
        System.out.println("Chi phí phẫu thuật: " + cost);
    }
}