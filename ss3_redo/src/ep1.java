import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ep1 {
    record User(String username, String email, String status){}

    public static void main(String[] args) {
        User u1 = new User("alice", "alice@gmail.com", "ACTIVE");
        User u2 = new User("zaba", "bob@gmail.com", "INACTIVE");
        User u3 = new User("charlie", "charlie@gmail.com", "ACTIVE");

        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(u1, u2, u3));

        // before java 8
//        users.sort(new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return o1.username.compareTo(o2.username);
//            }
//        });

        // lambda
        users.sort((a, b) -> a.username.compareTo(b.username));

        users.stream().forEach(user -> System.out.println(user.username));


    }
}
