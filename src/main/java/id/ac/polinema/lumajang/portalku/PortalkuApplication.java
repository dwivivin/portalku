package id.ac.polinema.lumajang.portalku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "id.ac.polinema.lumajang.portalku")
public class PortalkuApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalkuApplication.class, args);
	}

}
