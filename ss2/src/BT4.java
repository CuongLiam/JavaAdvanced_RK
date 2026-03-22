import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class BT4 {
    public class User {
        private final String userName;

        public User() {
            this.userName = "Default";
        }

        public User(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return this.userName;
        }
    }

    public static void main(String[] args) {
        BT4 bt4 = new BT4();
        List<User> users = new ArrayList<>();
        users.add(bt4.new User("Bob"));
        users.add(bt4.new User("Alice"));

        Function<User, String> f1 = User::getUserName;

        Consumer<String> f2 = System.out::println;

        Supplier<User> f3 = () -> bt4.new User();

        users.add(f3.get());

        users.stream().map(f1).forEach(f2);
    }
}