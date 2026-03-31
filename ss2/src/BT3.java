public class BT3 {
    @FunctionalInterface
    interface Authenticable {
        public String getPassword();

        default boolean isAuthenticated() {
            return getPassword() != null && !getPassword().isEmpty();
        }

        public static String encrypt(String rawPassword) {
            return "ENCRYPTED_" + rawPassword;
        }
    }

    class User implements Authenticable {
        private final String password;

        public User(String password) {
            this.password = password;
        }

        @Override
        public String getPassword() {
            return password;
        }
    }

    public static void main(String[] args) {
        BT3 bt3 = new BT3();
        String password = "123456";
        String encryptedPassword = Authenticable.encrypt(password);

        User us1 = bt3.new User(encryptedPassword);

        System.out.println("Your password: " + us1.getPassword());
        System.out.println("Authenticated: " + us1.isAuthenticated());

        User us2 = bt3.new User("");
        System.out.println("Authenticated (empty password): " + us2.isAuthenticated());
    }
}