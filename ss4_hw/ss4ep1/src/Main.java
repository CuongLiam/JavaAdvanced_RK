import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Main {
    @Nested
    class UserValidatorTest {
        public static boolean isValidUserName(String userName) {
            if (userName == null) {
                return false;
            }
            if (userName.length() < 6 || userName.length() >20) {
                return false;
            }
            return !userName.contains(" ");
        }

        @Test
        void TC01_validUserName() {
            assertTrue(UserValidatorTest.isValidUserName("abc123"));
        }

        @Test
        void TC02_tooShort() {
            assertFalse(UserValidatorTest.isValidUserName("abc"));
        }

        @Test
        void TC03_hasSpace() {
            assertFalse(UserValidatorTest.isValidUserName(""));
        }
    }
}