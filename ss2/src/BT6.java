public class BT6 {
    public class User {
        private final String userName;

        public User(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }
    }

    @FunctionalInterface
    interface UserProcessor {
        String process(User u);
    }

    public class UserUtils {
        public static String convertToUpperCase(User u) {
            return u.getUserName().toUpperCase();
        }
    }

    public static void main(String[] args) {
        BT6 bt6 = new BT6();
        UserProcessor processor = UserUtils::convertToUpperCase;

        User us1 = bt6.new User("Alice");

        String rs = processor.process(us1);
        System.out.println(rs);
    }
}