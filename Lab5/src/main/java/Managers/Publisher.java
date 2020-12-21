package Managers;

import Classes.Sensor;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

public class Publisher {
    private static Gson gson = new Gson();
    private final String MQTT = "MQTT";
    private final String HTTP = "HTTP";

    public Publisher(String method, String address, List<Sensor> sensors) throws InterruptedException, IOException {
        String METHOD = method.toUpperCase();
        if (METHOD.equals(MQTT)) {
            MQTTPublisher mqttPublisher = new MQTTPublisher(address, sensors);
            for (Sensor sensor : sensors) {
                sensor.RandomizeCurrentValue();
                mqttPublisher.publish(this.serializeSensor(sensor), "topic");
            }
        } else if (METHOD.equals(HTTP)) {
            HTTPPublisher httpPublisher = new HTTPPublisher(address, sensors);
            for (Sensor sensor : sensors) {
                httpPublisher.publish(this.serializeSensor(sensor));
            }
        } else {
            System.out.println("Unknown method! EXITING!");
            System.exit(1);
        }
    }

    private String serializeSensor(Sensor sensor) {
        return gson.toJson(sensor);
    }
}
