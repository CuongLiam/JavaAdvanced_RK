import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserEmailProcessorTest {
    private UserProcessor userProcessor;

    @BeforeEach
    public void setUp() {
        userProcessor = new UserProcessor();
    }

    @Test
    void testValidEmail() {
        String rs = userProcessor.processEmail("abc@def.com");
        assertEquals("abc@def.com", rs);
    }

    @Test
    void testMissingAtSymbol() {
        assertThrows(IllegalArgumentException.class, () -> userProcessor.processEmail("abcdef.com"));
    }

    @Test
    void testMissingDomain() {
        assertThrows(IllegalArgumentException.class, () -> userProcessor.processEmail("abc@"));
    }

    @Test
    void testEmailLowercase() {
        String rs = userProcessor.processEmail("Abc@Def.com");
        assertEquals("abc@def.com", rs);
    }
}
