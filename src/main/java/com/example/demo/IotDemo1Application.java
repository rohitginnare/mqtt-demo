package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IotDemo1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(IotDemo1Application.class, args);

		MqttSubscriber mqttSubscriber = context.getBean(MqttSubscriber.class);
        mqttSubscriber.subscribeToChannel();
	}

}
