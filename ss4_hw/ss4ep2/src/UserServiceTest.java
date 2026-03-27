public class UserServiceTest {
    public static class UserService {
        public static boolean checkRegistrationAge(int age) {
            if (age <= 0) {
                throw new IllegalArgumentException("Age must be positive");
            }
            return age >= 18;
        }
    }
}