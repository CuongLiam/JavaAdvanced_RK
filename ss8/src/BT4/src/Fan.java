public class Fan implements Observer {
    @Override
    public void update(int temperature) {
        if (temperature < 20) {
            System.out.println("Fan: Low temperature, auto OFF!");
        }
        else if (temperature <= 25) {
            System.out.println("Fan: Medium temperature, run at medium speed!");
        }
        else {
            System.out.println("Fan: High temperature, run at high speed!");
        }
    }
}
