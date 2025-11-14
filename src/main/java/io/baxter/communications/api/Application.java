package io.baxter.communications.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication(scanBasePackages = {
        "io.baxter.communications.api",
        "io.baxter.communications.infrastructure",
        "io.baxter.communications.data"
})
@EnableR2dbcRepositories(basePackages = "io.baxter.communications.data.repository")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
