package Classes;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Publisher {

    private static String address;
    private MqttClient mqttClient;

    public Publisher(String address) {
        this.address = address;
    }

    public void publishHTPP() {
    }
/*
    public void publishMQTT(String data, String topic) {
        try {
            mqttClient = new MqttClient(this.address, this.client);
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }

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

    public void setBroker(String address) {
        this.address = address;
    }*/
}