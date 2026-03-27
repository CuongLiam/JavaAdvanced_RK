package btth1;

public class btth1 {
    public static void main(String[] args) {
        System.out.println("hello world");

        EvenRunnable even = new EvenRunnable();
        OddRunnable odd = new OddRunnable();

//        Thread thread1 = new Thread(even);
//        Thread thread2 = new Thread(odd);

        Thread thread1 = new Thread(even);
        Thread thread2 = new Thread(odd);

        thread1.start();
        thread2.start();
        System.out.println("Thread chính kết thúc");

    }
}
