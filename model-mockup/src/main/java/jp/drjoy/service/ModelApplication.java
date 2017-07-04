package jp.drjoy.service;

import jp.drjoy.service.repository.MedicalOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"jp.drjoy.service.repository"})
public class ModelApplication {
	@Autowired
	private MedicalOfficeRepository medicalOfficeRepository;

	public static void main(String[] args) {
		SpringApplication.run(ModelApplication.class, args);
	}
}
