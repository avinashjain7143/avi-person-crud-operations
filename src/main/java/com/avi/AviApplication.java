package com.avi;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.avi.model.Person;
import com.avi.repository.PersonRepository;

@SpringBootApplication
public class AviApplication {

	public static void main(String[] args) {
		SpringApplication.run(AviApplication.class, args);
		System.out.println("Application started");
	}

	@Bean
	CommandLineRunner init(PersonRepository repository) {
		System.out.println("Loading persons");
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i -> new Person(i, "Avi " + i, "Jain " + i))
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};

	}
}
