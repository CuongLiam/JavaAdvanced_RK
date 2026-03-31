public class ACSetTemperatureCommand implements Command {
    private final AirConditioner airConditioner;
    private int newTemp;
    private int oldTemp;

    public ACSetTemperatureCommand(AirConditioner airConditioner, int newTemp) {
        this.airConditioner = airConditioner;
        this.newTemp = newTemp;
    }

    @Override
    public void execute() {
        oldTemp = airConditioner.getTemperature();
        airConditioner.setTemperature(newTemp);
    }

    @Override
    public void undo() {
        airConditioner.setTemperature(oldTemp);
    }
}
