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
		repository.save(new Book("Animal Farm", "George Orwell", 1980, "111-0-267-12563-7", 8.90));
		repository.save(new Book("Pride And Prejudice", "Jane Austen", 1980, "111-0-5656-44263-3", 8.90));
		repository.save(new Book("Neuromancer", "William Gibson", 1988, "152-0-5956-12534-8", 11.60));
		repository.save(new Book("The Lord of the Rings", "J. R. R. Tolkien", 2012, "173-8-032-12534-8", 17.60));
		repository.save(new Book("Hamlet", "William Shakespeare", 2013, "172-65032-85294-6", 17.60));
		
		log.info("Get all books");
		for (Book book : repository.findAll()) {
			log.info(book.toString());
		}
	};
	};
	
} 
