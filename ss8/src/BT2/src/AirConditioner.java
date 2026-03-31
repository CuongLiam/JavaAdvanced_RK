public class AirConditioner {
    public void off() {
        System.out.println("FACADE: Air conditioner is off");
    }

    public void setTemperature(int temperature) {
        System.out.println("FACADE: Air conditioner is set to " + temperature + " degrees");
    }
}
