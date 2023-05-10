package com.valcos98.inventoryjavatry;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.valcos98.inventoryjavatry.Entities.UserTable;
import com.valcos98.inventoryjavatry.repositories.UserRepository;

@SpringBootApplication
public class InventoryjavatryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryjavatryApplication.class, args);
	}

	@Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                UserTable user = new UserTable(name, name.toLowerCase() + "@domain.com");
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }
}
