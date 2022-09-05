package com.newproject.newproject;

import javafx.event.ActionEvent;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;


public class HelloController {

    public void OnButtonClicked(ActionEvent event) throws MqttException {
        MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
        client.connect();
        var message = new MqttMessage();
        message.setPayload("Hello world from Java".getBytes());
        client.publish("iot_data", message);
        client.disconnect();
    }
}