package Managers;

import Classes.Sensor;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.List;

public class MQTTPublisher {
    private static String BROKER;
    private MqttClient mqttClient;
    private List<Sensor> sensors;

    public MQTTPublisher(String address, List<Sensor> sensors) {
        this.BROKER = address;
        this.sensors = sensors;
        String client = "Stipo123";
        try {
            mqttClient = new MqttClient(BROKER, client);
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
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
