package com.example.Bookstore.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;



@Controller
public class BookController {

@Autowired
private BookRepository repository; 
	
	//Finds all books
	@RequestMapping("/booklist")//What endpoint this method will listen to
	public String bookList(Model model) { //Class model, sending it as a parameter to controller method
		model.addAttribute("books", repository.findAll()); //Key "students", value: all students from a database.
		return "booklist"; //Return: NAME OF THE TEMPLATE
	}
	
	//delete book
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET) //{id} path variable. Takes this variable and saves it to Lnog student id //
	public String deleteStudent (@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	//Add new book
		@RequestMapping (value="/addbook")
		public String addBook (Model model) { 
		model.addAttribute("book", new Book()); //Sends a new empty student object to thymeleaf template. We add one attribute to a model
		return "addbook"; //Showcases booklist html file
	}
		//Saves new students
		@RequestMapping (value ="/save", method = RequestMethod.POST)
		public String save (Book book) { //New book object from addbook in Thymeleaf and we save it in repository
			repository.save(book);
			return "redirect:booklist";
		}
}