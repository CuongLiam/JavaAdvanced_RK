import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class inClass {

    @FunctionalInterface
    interface mySum{
        int sum(int a, int b);
    }

    public static void main(String[] args) {
        // functionalInterface above

//        mySum s = (a, b) -> a + b;
//        System.out.println(s.sum(10, 5));

        // sorting

        List<String> names = new ArrayList<String>();
        names.add("John");
        names.add("Beth");
        names.add("Jack");
        names.add("Alice");

        // before java 8
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
//                return o2.compareTo(o1); //reverse
            }
        });

        // after java 8
        names.sort((a, b) -> a.compareTo(b));




        System.out.println(names);


        // method references

        // lambda
        names.forEach((i) -> System.out.println(i));

        // method references
        names.forEach(System.out::println);




    }
}
