import java.util.*;
import java.util.stream.Collectors;

public class ep4 {
    record User(String userName, String email, String status) {}

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", "a1@gmail.com", "active"));
        users.add(new User("Bob", "b1@gmail.com", "inactive"));
        users.add(new User("Charlie", "c1@gmail.com", "active"));
        users.add(new User("Alice", "a2@gmail.com", "inactive"));

        List<User> uniqueUsers = new ArrayList<>(
                users.stream()
                        .collect(Collectors.toMap(
                                user -> user.userName,
                                us -> us,
                                (us1, us2) -> us1)
                        )
                        .values()
        );

        uniqueUsers.forEach(us -> System.out.println(us.userName() + " - " + us.email() + " - " + us.status()));
    }
}
