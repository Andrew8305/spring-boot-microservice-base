package jp.drjoy.service.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import jp.drjoy.service.grpc.starter.EnableGrpcServer;

@SpringBootApplication
@EnableEurekaClient
@EnableGrpcServer
public class RegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationApplication.class, args);
	}
}
