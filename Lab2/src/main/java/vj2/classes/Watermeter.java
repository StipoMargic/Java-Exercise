package vj2.classes;

import java.util.Arrays;
import java.util.List;

public class Watermeter {
    public List<Sensor> Sensors;

    public Watermeter()
    {
        Sensors = Arrays.asList(new Sensor("Current Water temperature", "int16", 10, -32668, 32668, "Celsius"),
                new Sensor("Current water pressure", "uint16", 1000, 0, 65336, "Bar"),
                new Sensor("Consumption since 1 min, 10 min, 1 hour, 1 day", "uint16", 1, 0, 65336, "Liter"),
                new Sensor("Consumption since 1 week, 1 month, 1 year", "uint16", 10, 0, 65336, "CubicMeter"));
    }

    public void publish()
    {
        Publisher publisher = new Publisher();

        while(true) {
            for (Sensor sensor : Sensors) {
                sensor.RandomizeCurrentValue();
                publisher.publish(sensor.toString(), "topic");
            }
        }
    }
}
