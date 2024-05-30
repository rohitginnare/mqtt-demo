package com.example.demo;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MqttSubscriber {

    @Value("${mqtt.broker.url}")
    private String brokerUrl;

    @Value("${mqtt.client.id}")
    private String clientId;

    @Value("${mqtt.username}")
    private String username;

    @Value("${mqtt.password}")
    private String password;

    @Value("${mqtt.topic.channel}")
    private String channelTopic; // The MQTT topic for the specific channel

    public void subscribeToChannel() {
        try {
            MqttClient mqttClient = new MqttClient(brokerUrl, clientId);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setUserName(username);
            connOpts.setPassword(password.toCharArray());
            connOpts.setCleanSession(true);

            mqttClient.connect(connOpts);
            mqttClient.subscribe(channelTopic, (topic, message) -> {
                // Handle incoming report message here
                String payload = new String(message.getPayload());
                System.out.println("Received report on topic '" + topic + "': " + payload);
            });

        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
