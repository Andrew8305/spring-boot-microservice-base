package jp.drjoy.service.mobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MobileFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileFrontApplication.class, args);
	}
}
