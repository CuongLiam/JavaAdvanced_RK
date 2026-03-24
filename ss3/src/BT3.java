import java.util.*;

public class BT3 {
    public record User(String userName, String email, String status) {}

    public class UserRepository {
        private final List<User> users = List.of(new BT3.User("Alice", "alice@example.com", "active"), new BT3.User("Bob", "bob@example.com", "inactive"));

        public Optional<User> findUserByUsername(String userName) {
            return users.stream().filter(user -> user.userName().equals(userName)).findFirst();
        }
    }

    public static void main(String[] args) {
        BT3 bt3 = new BT3();
        UserRepository userRepository = bt3.new UserRepository();

        Optional<User> userOpt = userRepository.findUserByUsername("Bob");

        if (userOpt.isPresent()) {
            System.out.println("Welcome, " + userOpt.get().userName() + "!");
        }
        else {
            System.out.println("Guest login!");
        }

        System.out.println(userOpt.map(us -> "Welcome, " + us.userName() + "!").orElse("Guest login!"));
    }
}