package Projet_POO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "Projet_POO.Domain.Entity")
@EnableJpaRepositories(basePackages = "Projet_POO.Repository")

public class ProjetPooApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetPooApplication.class, args);
	}

}
