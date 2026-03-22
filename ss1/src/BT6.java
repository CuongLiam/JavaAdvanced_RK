import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BT6 {
    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String msg) {
            super(msg);
        }
    }

    // Logger
    public static class Logger {
        public static void logError(String message) {
            String time = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println("[ERROR] " + time + " - " + message);
        }
    }

    // Model User
    public static class User {
        private int age;
        private String name;

        public void setAge(int age) throws InvalidAgeException {
            if (age < 0) {
                throw new InvalidAgeException("Tuổi không thể âm!");
            }
            this.age = age;
        }

        public void setName(String name) {
            if (name != null) {
                this.name = name;
            } else {
                this.name = "Unknown";
            }
        }

        public void printInfo() {
            System.out.println("Tên: " + name + ", Tuổi: " + age);
        }
    }

    // Service
    public static class UserService {
        public static void processUser(User user, int age, String name)
                throws InvalidAgeException {

            user.setAge(age);
            user.setName(name);
        }
    }

    // Main
    public static void main(String[] args) {

        User user = new User();

        try {
            UserService.processUser(user, 20, null); // test
            user.printInfo();

        } catch (InvalidAgeException e) {
            Logger.logError(e.getMessage());

        } catch (Exception e) { // fallback
            Logger.logError("Lỗi không xác định: " + e.getMessage());

        } finally {
            System.out.println("Kết thúc chương trình");
        }
    }
}   