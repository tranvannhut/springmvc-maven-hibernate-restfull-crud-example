package com.nay.spring.dao;

import java.util.List;

import com.nay.spring.model.Book;

/**
 * @author nhuttv
 *
 */
public interface BookDAO {

	// insert record book into database
	public long saveBook(Book book);

	// get information of book base on id
	public Book getBook(int id);

	// get list information book
	public List<Book> listBooks();

	// update book
	public void updateBook(Book book, int id);

	// delete book
	public void deleteBook(int id);
}
