public class SmartHomeFACADE {
    private final Light light;
    private final Fan fan;
    private final AirConditioner airConditioner;
    private final TemperatureSensor sensor;

    public SmartHomeFACADE(TemperatureSensor sensor) {
        this.sensor = sensor;
        this.light = new Light();
        this.fan = new Fan();
        this.airConditioner = new AirConditioner();
    }

    public void leaveHome() {
        light.off();
        fan.off();
        airConditioner.off();
    }

    public void sleepMode() {
        light.off();
        fan.lowSpeed();
        airConditioner.setTemperature(25);
    }

    public void getCurrentTemperature() {
        double d = sensor.getTemperatureCelsius();
        System.out.println("Current temperature: " + String.format("%.2f", d) + " degrees");
    }
}
