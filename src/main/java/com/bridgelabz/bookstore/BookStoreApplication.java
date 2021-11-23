package com.bridgelabz.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BookStoreApplication.class, args);
		log.info("Bookstore Application Database username is {}"
				,context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
