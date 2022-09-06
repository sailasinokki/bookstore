package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class BookstoreApplication {
private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository repository) {
		return (args) -> {
		repository.save(new Book("Heart of Darkness", "Joseph Conrad", 1980, "111-0-252-12563-3", 8.90));
		repository.save(new Book("Animal Farm", "George Orwell", 1980, "111-0-252-12563-3", 8.90));
		repository.save(new Book("Pride And Prejudice", "Jane Austen", 1980, "111-0-5656-12563-3", 8.90));
		
		log.info("Get all books");
		for (Book book : repository.findAll()) {
			log.info(book.toString());
		}
	};
	};
	
} 
