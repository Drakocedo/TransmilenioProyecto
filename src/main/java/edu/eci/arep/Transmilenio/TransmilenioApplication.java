package edu.eci.arep.Transmilenio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arep.TransmilenioApp"})
public class TransmilenioApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransmilenioApplication.class, args);
	}

}
