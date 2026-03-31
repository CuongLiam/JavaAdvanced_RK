import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class inClass {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(7);
        numbers.add(9);

        numbers.addAll(Arrays.asList(1,2,4,5,6,7,100,10));

        printEvenNumList(numbers);

        withouStream(numbers);
        System.out.println();
        withStream(numbers);

        System.out.println();
        System.out.println(numbers);
    }

    static void withouStream(List<Integer> nums){
        long count = 0;

        for (int i = 0; i < nums.toArray().length; i++){
            if (nums.get(i) % 2 == 0){
                count++;
            }
        }

        System.out.printf("có %d phần tử chẵn. ", count);
    }

    static void withStream(List<Integer> nums){
        long count = nums.stream().filter(num -> num % 2 == 0).count();

        System.out.printf("có %d phần tử chẵn. ", count);
    }

    static void printEvenNumList(List<Integer> nums){
        List<Integer> numList = nums.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());

        System.out.println(numList);
    }

}
