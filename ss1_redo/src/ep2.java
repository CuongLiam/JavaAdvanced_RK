import java.util.Scanner;

public class ep2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap tong so nguoi: ");
        int total = sc.nextInt();
        System.out.println("So luong nhom muon chia se: ");
        int groups = sc.nextInt();

        try {
            int perGroup = total / groups;

            System.out.println("1 nhóm nên có: "+perGroup+" người");
        } catch (ArithmeticException e){
            System.out.println("Không thể chia cho 0!");
        } finally {
            sc.close();
        }

    }
}
