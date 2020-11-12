package Lab3.classes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Watermeter {
    private static Gson gson = new Gson();
    private static ObjectMapper mapper = new ObjectMapper();
    private String brokerAddress;
    public int delay;
    private List<Sensor> sensors;

    public void publish() throws InterruptedException {
        Publisher publisher = new Publisher(brokerAddress);

        while (true) {
            TimeUnit.SECONDS.sleep(delay);
            for (Sensor sensor : sensors) {
                sensor.RandomizeCurrentValue();
                publisher.publish(Watermeter.serializeSensor(sensor), "topic");
            }
        }
    }

    public static Watermeter createWatermeter(String path) throws IOException {
        return mapper.readValue(new File(path), Watermeter.class);
    }

    public static String serializeSensor(Sensor sensor) {
        return gson.toJson(sensor);
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public void setBrokerAddress(String brokerAddress) {
        this.brokerAddress = brokerAddress;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
