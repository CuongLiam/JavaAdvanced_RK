public class BT2 {
    @FunctionalInterface
    interface PasswordValidator {
        boolean isValid(String password);
    }

    public static void main(String[] args) {
        PasswordValidator pwv = password -> password.length() >= 8;

        String testPassword1 = "pass123";
        String testPassword2 = "password123";

        System.out.println("Is '" + testPassword1 + "' a valid password? " + pwv.isValid(testPassword1));
        System.out.println("Is '" + testPassword2 + "' a valid password? " + pwv.isValid(testPassword2));
    }
}