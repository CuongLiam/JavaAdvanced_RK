import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Main {
    @Test
    void TC01_age18_valid() {
        boolean rs = UserServiceTest.UserService.checkRegistrationAge(18);
        assertTrue(rs);
    }

    @Test
    void TC02_ageUnder18_invalid() {
        boolean rs = UserServiceTest.UserService.checkRegistrationAge(17);
        assertFalse(rs);
    }

    @Test
    void TC03_ageNegative_invalid() {
        assertThrows(IllegalArgumentException.class, () -> UserServiceTest.UserService.checkRegistrationAge(-1));
    }
}
