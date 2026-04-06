import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ep5 {
    record User (int id, String username){};

    public static void main(String[] args) {
        List<User> users =  new ArrayList<>();

        User u1 = new User(1, "alexander");
        User u2 = new User(2, "charlotte");
        User u3 = new User(3, "Benjamin");
        User u4 = new User(4, "zebraoad");
        User u5 = new User(5, "uquwuuwuuauaosas");

        users.addAll(Arrays.asList(u1, u2, u3, u4, u5));

        List<User> longestUser ;

        longestUser = users.stream()
                .sorted((a, b)-> b.username.length() - a.username.length())
                .limit(2)
//                .collect(Collectors.toList());
                .toList();

        longestUser.forEach(u -> System.out.println(u.username()));


    }

}
