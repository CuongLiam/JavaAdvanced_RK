public class BT5 {
    public class InvalidAgeException extends Exception {
        public InvalidAgeException(String msg) {
            super(msg);
        }
    }

    public class User {
        private int age;

        public void setAge(int age) throws InvalidAgeException {
            if (age < 0) {
                throw new InvalidAgeException("Tuoi khong duoc am!");
            }

            this.age = age;
        }

        public void getAge() {
            System.out.println("Tuoi cua ban la: " + age);
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        BT5 bt5 = new BT5();
        User user = bt5.new User();

        try {

            user.setAge(-5);
            user.getAge();
        }

        catch (InvalidAgeException e) {

            System.out.println("Co loi xay ra: " + e.getMessage());
            e.printStackTrace(); // In chi tiết lỗi ra console
        }

        finally {
            System.out.println("Cam on da su dung chuong trinh!");
        }
    }
}