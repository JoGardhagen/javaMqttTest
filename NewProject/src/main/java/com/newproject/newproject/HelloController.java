package com.newproject.newproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;


public class HelloController {

    @FXML
    public ListView MessageListView;
    @FXML
    public TextField MsgBox;
    public CheckBox MarkTosend;


    private boolean markCheck = false;
    public HelloController() throws MqttException {
    }

    public void OnButtonClicked(ActionEvent event) throws MqttException {
        MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
        if (markCheck){
            String messageToSend = MsgBox.getText();
            client.connect();
            var message = new MqttMessage();
            message.setPayload(messageToSend.getBytes());
            client.publish("iot_data", message);
            client.disconnect();
        }

    }

    public void OnMarked(ActionEvent event) {
        if (!markCheck){
            markCheck = true;
        }else markCheck = false;
    }
}