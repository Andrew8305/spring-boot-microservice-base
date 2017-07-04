package jp.drjoy.service.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerApplication {

	//@Profile("default")
	//@Override public void afterPropertiesSet() throws Exception {
	//	// Load ssh key
	//	URL uri = ConfigServerApplication.class.getClassLoader().getResource("ssh-keys/id_rsa");
	//	if (uri == null) {
	//		throw new NullPointerException("SSH key is null");
	//	}
	//}

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
