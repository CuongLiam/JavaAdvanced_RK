public class Humidifier implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Humidifier: " + temperature + " °C");
    }
}
