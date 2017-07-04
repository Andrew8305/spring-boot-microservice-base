package jp.drjoy.service.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class FrontGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontGatewayApplication.class, args);
	}
}
