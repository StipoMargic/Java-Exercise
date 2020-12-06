package com.example.restservice;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Publisher {
    private MqttClient mqttClient;

    public Publisher(String brokerAddress, String client) {
        try {
            this.mqttClient = new MqttClient(brokerAddress, client);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
    public void publish(String data, String topic) {
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setPayload(data.getBytes());
        try {
            this.mqttClient.connect();
            this.mqttClient.publish(topic, mqttMessage);
            this.mqttClient.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
