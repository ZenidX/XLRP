package xlrp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Main{
	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(Main.class);
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		LOGGER.info("Funciona?");
	}
}
