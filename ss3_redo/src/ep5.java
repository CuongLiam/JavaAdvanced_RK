import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ep5 {
    record User (int id, String username){};

    public static void main(String[] args) {
        List<User> users =  new ArrayList<>();

        User u1 = new User(1, "alexander");
        User u2 = new User(2, "charlotte");
        User u3 = new User(3, "Benjamin");

        users.addAll(Arrays.asList(u1, u2, u3));

        List<User> longestUser ;




    }

}
