package BT3.src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter bed ID to update:");
        int bedId = scanner.nextInt();

        System.out.println("Enter new status (Occupied/Available):");
        String status = scanner.next();

        BedService.updateBedStatus(bedId, status);

        scanner.close();
    }
}