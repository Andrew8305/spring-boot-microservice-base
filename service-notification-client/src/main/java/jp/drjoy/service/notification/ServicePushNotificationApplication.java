package jp.drjoy.service.notification;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableRabbit
@EnableScheduling
@EnableMongoRepositories("jp.drjoy.service.notification.repository")
public class ServicePushNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicePushNotificationApplication.class, args);
	}
}
