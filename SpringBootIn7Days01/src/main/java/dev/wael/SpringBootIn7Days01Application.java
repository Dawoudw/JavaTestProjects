package dev.wael;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan("dev.wael")// not required 
//@EntityScan("dev.wael.model")
//@EnableJdbcRepositories("dev.wael.dao")
//@EnableJpaRepositories("dev.wael.dao")
public class SpringBootIn7Days01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIn7Days01Application.class, args);
	}

}
