package BT4.src;

public class InputValidator {

    public static String sanitize(String input) {
        if (input == null) return "";

        return input
                .replace("--", "")
                .replace("'", "")
                .replace("\"", "")
                .replace(";", "");
    }
}