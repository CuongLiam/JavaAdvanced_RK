import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private int temperature;

    @Override
    public void attach(Observer o) {
        observers.add(o);
        System.out.println("The observer " + o + " has been attached to the subject!");
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
        System.out.println("The observer " + o + " has been detached from the subject!");
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Temperature has been changed to " + temperature + " °C!");
        notifyObservers();
    }
}
