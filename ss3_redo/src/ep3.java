import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ep3 {
    record User(String username, String email){}

    static class UserRepository{
        static List<User> users = new ArrayList<>(List.of(
                new User("Alice", "alice@gmail.com"),
                new User("Zebawa", "Zebawa@yahoo.com"),
                new User("Josh", "josh@gmail.com")
        ));

        Optional<User> findUserByUsername(String username) {
            return users.stream()
                        .filter(user -> user.username.equals(username))
                        .findFirst();
        }
    }

    public static void main(String[] args) {
        UserRepository repository = new UserRepository();

        Optional<User> userOptional = repository.findUserByUsername("Alice");

        if (userOptional.isPresent()){
            System.out.println("Welcome, " + userOptional.get().username() + "!");
        } else{
            System.out.println("Guest login!");
        }

        System.out.println(userOptional.map(us -> "Welcome, " + us.username() + "!")
                                    .orElse("Guest login!"));


    }
}
