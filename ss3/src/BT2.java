import java.util.*;

public class BT2 {
    record User(String userName, String email, String status) {}

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", "alice@gmail.com", "active"));
        users.add(new User("Bob", "bob@example.com", "inactive"));

        users.stream().filter(user -> user.email().endsWith("@gmail.com"))
                    .forEach(user -> System.out.println(user.userName()));
    }

}