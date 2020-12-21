package Classes;

import Managers.Publisher;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Watermeter {

    private static Gson gson = new Gson();
    private static ObjectMapper mapper = new ObjectMapper();
    private String address;
    public String method;
    private List<Sensor> sensors;

    public void publish() throws InterruptedException, IOException {
        Publisher publisher = new Publisher(method, address, sensors);
    }

    public static Watermeter createWatermeter(String path) throws IOException {
        return mapper.readValue(new File(path), Watermeter.class);
    }

    private String serializeSensor(Sensor sensor) {
        return gson.toJson(sensor);
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}

