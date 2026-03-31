import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ep2 {
    record User(String username, String email){}

    public static void main(String[] args) {
        User u1 = new User("Alice", "alice@gmail.com");
        User u2 = new User("Zebawa", "Zebawa@yahoo.com");
        User u3 = new User("Josh", "josh@gmail.com");

        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(u1, u2, u3));

        users.sort((a, b) -> b.username.compareTo(a.username));

        users.stream().filter(user -> user.email.endsWith("@gmail.com"))
                .forEach(user -> System.out.println(user.username));

    }

}
