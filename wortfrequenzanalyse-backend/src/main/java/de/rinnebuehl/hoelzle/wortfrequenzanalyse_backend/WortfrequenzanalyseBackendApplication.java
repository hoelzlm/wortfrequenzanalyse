package de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend;

import de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.model.Wortfrequenz;
import de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.repository.DatabaseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WortfrequenzanalyseBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WortfrequenzanalyseBackendApplication.class, args);
	}

	@Bean
	// This runner puts something in the database to test
	public CommandLineRunner demo(DatabaseRepository repository) {
		return (args) -> {
			repository.save(new Wortfrequenz("test.pdf", "Hello", 1));
			repository.save(new Wortfrequenz("test.pdf", "World", 1));
		};
	}
}
