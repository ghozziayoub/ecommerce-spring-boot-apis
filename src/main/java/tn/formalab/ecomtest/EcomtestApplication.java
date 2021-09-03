package tn.formalab.ecomtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class EcomtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomtestApplication.class, args);
	}

}
