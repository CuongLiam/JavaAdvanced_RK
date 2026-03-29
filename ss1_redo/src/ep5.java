public class ep5 {
    public static void main(String[] args) {
        User user1 = new User();

        try{
            user1.setAge(-1);
        } catch (InvalidAgeException e){
            System.out.println(e.getMessage());
        }
    }


    static class InvalidAgeException extends Exception{

        public InvalidAgeException(String msg){
            super(msg);

        }
    }
    static class User{
        int age;

        public User() {

        }

        public int getAge() {
            return age;
        }


        public void setAge(int age) throws InvalidAgeException {
            if (age <= 0) {
                throw new InvalidAgeException("Tuổi không thể âm!");
            }
            this.age = age;
        }
    }
}
