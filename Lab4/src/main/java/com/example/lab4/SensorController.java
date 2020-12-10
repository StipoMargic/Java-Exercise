package com.example.lab4;

import org.springframework.web.bind.annotation.*;

@RestController
public class SensorController {
    @PostMapping(value = "/sensor")
    public void createSensor(@RequestBody Sensor sensor) {
        Publisher publisher = new Publisher(sensor.getBrokerAddress(), sensor.getClient());
        publisher.publish(sensor.getMessage(), sensor.getTopic());
    }

    @GetMapping("/test")
    public String test() {
        return "str";
    }
}
