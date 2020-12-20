package com.example.lab4;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Publisher extends Request {
    private MqttClient mqttClient;

    public void publish(Request request) {
        try {
            this.mqttClient = new MqttClient(request.getBrokerAddress(), request.getClient());
        } catch (MqttException e) {
            e.printStackTrace();
        }

        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setPayload(request.getMessage().getBytes());
        try {
            this.mqttClient.connect();
            this.mqttClient.publish(request.getTopic(), mqttMessage);
            this.mqttClient.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

}
