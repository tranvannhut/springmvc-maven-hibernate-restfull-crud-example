package com.nay.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nay.spring.model.Book;
import com.nay.spring.service.BookService;

/**
 * Handle request
 * @author nhutt
 *
 */
@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	/*---get all books---*/
	@GetMapping(value = "/listBook")
	public ResponseEntity<List<Book>> listBook() {
		List<Book> listBooks = bookService.listBooks();
		return ResponseEntity.ok().body(listBooks);
	}

	/*---Add new book---*/
	@PostMapping(value = "/saveBook")
	public ResponseEntity<?> saveBook(@RequestBody Book book) {
		long id = bookService.saveBook(book);
		return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
	}

	/*---Get a book by id---*/
	@GetMapping(value = "/book/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
		Book book = bookService.getBook(id);
		return ResponseEntity.ok().body(book);
	}

	/*---Update a book by id---*/
	@PutMapping(value = "/book/{id}")
	public ResponseEntity<?> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
		bookService.updateBook(book, id);
		return ResponseEntity.ok().body("Book has been updated successfully.");
	}

	/*---detele a book by id---*/
	@DeleteMapping(value = "/book/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") int id) {
		bookService.deleteBook(id);
		return ResponseEntity.ok().body("Book has been deleted successfully.");
	}
}
