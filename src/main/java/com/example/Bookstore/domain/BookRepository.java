package com.example.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>  { //(Rajapintaluokka)Entity class where repository belongs, what type is book id / Perii CRUd repository-luokan
	
	List<Book> findByTitle(String title);
}
