public class ep2 {

    @FunctionalInterface
    interface PasswordValidator{
        boolean isValid(String password);
    }

    public static void main(String[] args) {

        // classic way
        PasswordValidator validator = new PasswordValidator() {
            @Override
            public boolean isValid(String password) {
                return password.length() >= 8;
            }
        };

        //lambda

        PasswordValidator validator2 = password -> password.length() >= 8;

        String testPassword = "abc123";
        String testPassword2 = "abc123213123123";

        System.out.println("Is '" + testPassword + "' a valid password? " + validator2.isValid(testPassword));
        System.out.println("Is '" + testPassword2 + "' a valid password? " + validator2.isValid(testPassword2));
    }

}
