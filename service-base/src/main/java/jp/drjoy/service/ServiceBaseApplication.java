package jp.drjoy.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "jp.drjoy.service" })
public class ServiceBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBaseApplication.class, args);
	}
}
