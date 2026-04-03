package BT4.src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tên bệnh nhân: ");
        String name = sc.nextLine();

        PatientService.findPatientByName(name);

        sc.close();
    }
}