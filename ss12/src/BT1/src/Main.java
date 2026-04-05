package BT1.src;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    DoctorDAO dao = new DoctorDAO();

    System.out.print("Enter code: ");
    String code = sc.nextLine();

    System.out.print("Enter password: ");
    String pass = sc.nextLine();

    if (dao.login(code, pass)) {
      System.out.println("Login success!");
    } else {
      System.out.println("Login failed!");
    }
  }
}