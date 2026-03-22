public class BT3 {
    public class User {
        private int age;

        public void setAge(int age) {
            if (age < 0) {
                throw new IllegalArgumentException("Tuoi khong duoc am!");
            }

            this.age = age;
        }

        public void getAge() {
            System.out.println("Tuoi cua ban la: " + age);
        }
    }

    public static void main(String[] args) {
        BT3 bt3 = new BT3();
        User user = bt3.new User();

        // user.setAge(-5);
        user.setAge(25);
        user.getAge();
    }
}