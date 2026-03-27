package btth1;

public class OddRunnable implements Runnable{
    @Override
    public void run(){
        for (int i = 1; i <= 9; i = i + 2){
            System.out.println("Số lẻ: "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
