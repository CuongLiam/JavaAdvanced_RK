public class Main {
    public static void main(String[] args) {
        TemperatureSensor ts = new TemperatureSensor();

        Observer fan = new Fan();
        Observer humidifier = new Humidifier();

        ts.attach(fan);
        ts.attach(humidifier);

        ts.setTemperature(22);
        ts.setTemperature(28);
        ts.setTemperature(18);

        ts.detach(fan);
        ts.setTemperature(25);
    }
}