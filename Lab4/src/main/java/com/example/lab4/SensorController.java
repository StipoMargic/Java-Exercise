package com.example.lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SensorController {
    @Autowired
    private Publisher publisher;

    @PostMapping(value = "/sensor")
    public void createSensor(@RequestBody Request request) {
        publisher.publish(request);
    }
}
