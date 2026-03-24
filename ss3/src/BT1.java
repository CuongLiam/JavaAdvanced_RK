import java.util.*;

public class BT1 {
    record User(String userName, String email, String status) {}

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", "alice@example.com", "active"));
        users.add(new User("Bob", "bob@example.com", "inactive"));

        users.forEach(us -> System.out.println(us.userName() + " - " + us.email() + " - " + us.status()));
    }
}