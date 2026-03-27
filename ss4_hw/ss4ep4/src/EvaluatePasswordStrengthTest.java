import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvaluatePasswordStrengthTest {
    private PasswordService passwordService;

    @BeforeEach
    void setUp() {
        passwordService = new PasswordService();
    }

    @Test
    void testStrongPassword() {
        assertEquals("Strong!", passwordService.evaluatePasswordStrength("Password123!"));
    }

    @Test
    void testMediumPassword() {
        assertAll(
                () -> assertEquals("Medium!", passwordService.evaluatePasswordStrength("Password123")),
                () -> assertEquals("Medium!", passwordService.evaluatePasswordStrength("Password!")),
                () -> assertEquals("Medium!", passwordService.evaluatePasswordStrength("password123!"))
        );
    }

    @Test
    void testWeakPassword() {
        assertAll(
                () -> assertEquals("Weak!", passwordService.evaluatePasswordStrength("Ab1")),
                () -> assertEquals("Weak!", passwordService.evaluatePasswordStrength("ABC123")),
                () -> assertEquals("Weak!", passwordService.evaluatePasswordStrength("password"))
        );
    }
}
