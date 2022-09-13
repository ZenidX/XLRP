package SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringBoot1Application {
	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(SpringBoot1Application.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot1Application.class, args);
		LOGGER.info("Funciona?");
	}
}
