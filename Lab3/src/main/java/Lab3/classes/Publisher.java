package Lab3.classes;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Publisher {
    private static String BROKER;
    private MqttClient mqttClient;q

    public Publisher(String broker) {
        BROKER = broker;
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

    public void setBroker(String broker) {
        BROKER = broker;
    }
}