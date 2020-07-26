package dev.wael.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("dev.wael")
@EnableJpaRepositories("dev.wael.repositories")
@EntityScan("dev.wael.entities")
public class SpringBootToDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootToDoApplication.class, args);
	}

}
