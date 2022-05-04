package com.nay.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nay.spring.dao.BookDAO;
import com.nay.spring.model.Book;

@Service
@Transactional(readOnly = false)
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;

	@Transactional
	@Override
	public long saveBook(Book book) {
		return bookDAO.saveBook(book);
	}

	@Transactional
	@Override
	public Book getBook(int id) {
		return bookDAO.getBook(id);
	}

	@Transactional
	@Override
	public List<Book> listBooks() {
		return bookDAO.listBooks();
	}

	@Override
	public void updateBook(Book book, int id) {
		bookDAO.updateBook(book, id);

	}

	@Override
	public void deleteBook(int id) {
		bookDAO.deleteBook(id);

	}

}
