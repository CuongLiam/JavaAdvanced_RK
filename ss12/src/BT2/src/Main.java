package BT2.src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VitalsDAO dao = new VitalsDAO();

        System.out.print("Patient ID: ");
        int id = sc.nextInt();

        System.out.print("Temperature: ");
        double temp = sc.nextDouble();

        System.out.print("Heart rate: ");
        int hr = sc.nextInt();

        if (dao.updateVitals(id, temp, hr)) {
            System.out.println("Update success!");
        } else {
            System.out.println("Update failed!");
        }
    }
}