import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ep4 {
    static class User{
        String username;

        public User(String username) {
            this.username = username;
        }

        public User() {

        }

        public String getUsername() {
            return username;
        }
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        User u1 = new User("John");
        User u2 = new User("Alice");
        User u3 = new User("Zebra");

        users.add(u1);
        users.add(u2);
        users.add(u3);

        // lambda
        List<String> names = users.stream()
                                .map((user -> user.getUsername()))
                                .collect(Collectors.toList());

        // Method Reference:
        List<String> names2 = users.stream()
                .map(User::getUsername)
                .collect(Collectors.toList());

        System.out.println(names);


        // lambda

        users.forEach(u -> System.out.println(u.getUsername()));

        // mr
        names.forEach(System.out::println);


        //constructure

        // Lambda:
        // Supplier<User> supplier = () -> new User();

        // Method Reference:
        Supplier<User> supplier = User::new;

        User newUser = supplier.get();
        System.out.println(newUser.getUsername());




    }
}
