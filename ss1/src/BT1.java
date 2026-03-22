import java.util.Scanner;

public class BT1 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        try {

            System.out.println("Nhap nam sinh: ");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();

            sc.close();

            int year = 2026 - Integer.parseInt(str);

            System.out.println("Tuoi cua ban la: " + year);

        } catch (NumberFormatException e) { // Ngoại lệ khi nhập không phải là số

            System.out.println("Loi: Vui long nhap nam sinh hop le!");

        } finally {

            System.out.println("Cam on ban da su dung chuong trinh!");
        }
    }
}