public class ep3 {
    interface Authenticatable {
        String getPassword();

        default boolean isAuthenticated(){
            if (getPassword().isEmpty() || getPassword() == null){
                System.out.println("Mk rỗng!");
                return false;
            }
            return true;
        }

        static String encrypt(String rawPassword){
            return "Mã hoá... "+rawPassword;
        }
    }

    static class User implements Authenticatable{
        private final String password;

        public User(String password){
            this.password = password;
        }

        @Override
        public String getPassword(){
            return password;
        }
    }

    public static void main(String[] args) {
        User user1 = new User("abc123");
        User user2 = new User("");


        String password = "124567";
        String encryptedPassword = Authenticatable.encrypt(password);
        System.out.println(encryptedPassword);

        System.out.println("auth "+user2.isAuthenticated());

        System.out.println("u1: "+user1.getPassword());
        System.out.println("u2: "+user2.getPassword());


    }
}
