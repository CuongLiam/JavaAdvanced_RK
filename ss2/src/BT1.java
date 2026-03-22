import java.util.function.*;

public class BT1 {
    public class User {
        private final String name;
        private final String role;

        public User(String name, String role) {
            this.name = name;
            this.role = role;
        }

        public String getName() {
            return name;
        }

        public String getRole() {
            return role;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", role='" + role + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        BT1 bt1 = new BT1();

        Predicate<User> isAdmin = user -> user.getRole().equalsIgnoreCase("admin");

        Function<User, String> getUserName = user -> user.getName();

        Consumer<User> printUserInfo = user -> System.out.println(user);

        Supplier<User> createUser = () -> bt1.new User("Alice", "admin");

        User u1 = bt1.new User("Bob", "user");
        User u2 = createUser.get();

        System.out.println("Is u1 an admin? " + isAdmin.test(u1));
        System.out.println("Is u2 an admin? " + isAdmin.test(u2));

        System.out.println("u1's name: " + getUserName.apply(u1));

        printUserInfo.accept(u1);
        printUserInfo.accept(u2);
    }
}