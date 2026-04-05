package BT4.src;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<TestResult> list = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            list.add(new TestResult("Data " + i));
        }

        InsertService.insertResults(list);

        System.out.println("Insert thành công!");
    }
}