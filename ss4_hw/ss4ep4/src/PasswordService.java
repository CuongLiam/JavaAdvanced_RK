public class PasswordService {
    public String evaluatePasswordStrength(String pass) {
        if (pass == null || pass.isEmpty() || pass.length() < 8) {
            return "Weak!";
        }

        boolean hasUpper = pass.matches(".*[A-Z].*");
        boolean hasLower = pass.matches(".*[a-z].*");
        boolean hasDigit = pass.matches(".*\\d.*");
        boolean hasSpecial = pass.matches(".*[^a-zA-Z0-9].*");

        int count = 0;

        if (hasDigit) count++;
        if (hasUpper) count++;
        if (hasLower) count++;
        if (hasSpecial) count++;

        if (count == 4) return "Strong!";
        if (count == 3) return "Medium!";

        return "Weak!";
    }
}