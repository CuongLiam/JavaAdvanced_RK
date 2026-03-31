import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ep1 {
    class User{
        private String username;
        private String role;

        public User(String username, String role) {
            this.username = username;
            this.role = role;
        }

        public String getUsername() {
            return username;
        }

        public String getRole() {
            return role;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", role='" + role + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        ep1 Ep1 = new ep1();

        Predicate<User> isAdmin = user -> user.getRole()
                                                    .equalsIgnoreCase("admin");

        Function<User, String> getUserName = user -> user.getUsername();

        Consumer<User> printUserInfo = user -> System.out.println(user);

        Supplier<User> createUser = () -> Ep1.new User("Alice", "admin");

        User u1 = Ep1.new User("Bob", "user");
        User u2 = createUser.get();

        System.out.println("Is u1 an admin? " + isAdmin.test(u1));
        System.out.println("Is u2 an admin? " + isAdmin.test(u2));

        System.out.println("u1's name: " + getUserName.apply(u1));

        printUserInfo.accept(u1);
        printUserInfo.accept(u2);


    }
}
