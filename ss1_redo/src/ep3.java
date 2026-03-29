public class ep3 {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setAge(-1);


        System.out.println(user1.getAge());

    }

    static class User{
        int age;

        public User() {

        }

        public int getAge() {
            return age;
        }


        public void setAge(int age) {
            if (age <= 0) {
                throw new IllegalArgumentException("Tuổi không thể âm!");
            }
            this.age = age;
        }
    }
}
