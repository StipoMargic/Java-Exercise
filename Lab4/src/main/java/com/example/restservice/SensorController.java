package com.example.restservice;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

@RestController
public class SensorController {
    private static Gson gson = new Gson();

    @RequestMapping(method = RequestMethod.POST, value = "/message")
    public void createSensor(@RequestBody Sensor sensor) {
        Publisher publisher = new Publisher(sensor.getBrokerAddress(), sensor.getClient());
        publisher.publish(sensor.getMessage(), sensor.getTopic());
    }
}
