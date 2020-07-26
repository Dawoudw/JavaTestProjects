package dev.wael.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import dev.wael.repositories.IAssociateRepository;

@SpringBootApplication
@EntityScan("dev.wael.entities")
@ComponentScan("dev.wael")
@EnableJpaRepositories("dev.wael.repositories")
public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(App.class, args);
	}

}
