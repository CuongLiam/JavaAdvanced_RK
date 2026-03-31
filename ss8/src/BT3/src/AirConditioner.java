public class AirConditioner {
    private int temperature = 25;

    public void setTemperature(int temperature) {
        System.out.println("Air Conditioner set to " + temperature + " degrees");
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}
