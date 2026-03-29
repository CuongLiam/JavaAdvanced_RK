import java.util.Scanner;

public class ep1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            String input = sc.nextLine();
            int age = 2026 - Integer.parseInt(input);

            System.out.println("passed");
        } catch (NumberFormatException e){
            System.out.println("sai định dạng vui lòng nhập lại int. "+e);

        } finally {
            System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");
            sc.close();
        }
    }
}
