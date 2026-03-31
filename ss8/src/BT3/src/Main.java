public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner airConditioner = new AirConditioner();

        RemoteControl remote = new RemoteControl();

        remote.setCommand(0, new LightOnCommand(light));
        remote.setCommand(1, new LightOffCommand(light));
        remote.setCommand(2, new FanOnCommand(fan));
        remote.setCommand(3, new FanOffCommand(fan));
        remote.setCommand(4, new ACSetTemperatureCommand(airConditioner, 20));

        remote.pressButton(0);
        remote.pressButton(2);
        remote.pressButton(4);

        System.out.println("Undo:");
        remote.undo();
        remote.undo();

        System.out.println("Redo:");
        remote.redo();
    }
}