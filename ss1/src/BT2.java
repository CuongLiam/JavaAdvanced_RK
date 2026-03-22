import java.util.Scanner;

public class BT2 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap tong so nguoi: ");
            int n = sc.nextInt();

            System.out.println("Nhap tong so nhom: ");
            int k = sc.nextInt();

            int divide = n / k;
            System.out.println("So nguoi trong moi nhom la: " + divide);

            sc.close();
        }

        catch (ArithmeticException e) { // Ngoại lệ chia cho 0

            System.out.println("Loi: So nhom khong duoc bang 0!");
        }

        catch (Exception e) {

            System.out.println("Loi: Vui long nhap du lieu hop le!");
        }

        finally {
            System.out.println("Cam on ban da su dung chuong trinh!");
        }
    }
}