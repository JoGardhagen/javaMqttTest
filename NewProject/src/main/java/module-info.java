module com.newproject.newproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.eclipse.paho.client.mqttv3;


    opens com.newproject.newproject to javafx.fxml;
    exports com.newproject.newproject;
}