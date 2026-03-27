import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class inClass_1 {
    public static void main(String[] args) {
//        String ageInput = "ants";
//
//
//        try {
//            int age = Integer.parseInt(ageInput);
//
//            System.out.println("Age: "+age);
//        } catch (NumberFormatException e){
//            System.out.println(e);
//            System.out.println("Lỗi đầu vào: nhập số hợp lệ");
//        }


        try {
            readStudentData("/data.txt");

//            File file = new File("data.txt");
//
//            if (!file.exists()){
//                throw new FileNotFoundException("file ko tồn tại");
//            }
//
//            Scanner sc = new Scanner(file);
//            System.out.println("Đang đọc dữ liệu...");
//            sc.close();

        } catch (FileNotFoundException e){
            System.out.println("Lỗi: k tìm thấy file. "+e.getMessage());
        }

        System.out.println("hello world!");

    }

    public static void readStudentData(String fileName) throws FileNotFoundException{
        File file = new File(fileName);

        Scanner sc = new Scanner(file);
        System.out.println("Đang đọc dữ liệu...");
        sc.close();
    }
}
