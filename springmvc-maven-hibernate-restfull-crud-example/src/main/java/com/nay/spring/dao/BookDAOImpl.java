package com.nay.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nay.spring.model.Book;

/**
 * perform CRUD for information book
 * 
 * @author nhutt
 *
 */
@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * save information book
	 * 
	 * @see com.nay.spring.dao.BookDAO#saveBook(com.nay.spring.model.Book)
	 */
	@Override
	public long saveBook(Book book) {
		// save object book
		sessionFactory.getCurrentSession().save(book);
		return book.getId();
	}

	/*
	 * get information book specific
	 * 
	 * @see com.nay.spring.dao.BookDAO#getBook(int)
	 */
	@Override
	public Book getBook(int id) {
		return sessionFactory.getCurrentSession().get(Book.class, id);
	}

	/*
	 * get all information of book
	 * 
	 * @see com.nay.spring.dao.BookDAO#listBooks()
	 */
	@Override
	public List<Book> listBooks() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Book> cq = cb.createQuery(Book.class);
		Root<Book> root = cq.from(Book.class);
		cq.select(root);
		Query<Book> query = session.createQuery(cq);
		return query.getResultList();
	}

	/*
	 * update information book
	 * 
	 * @see com.nay.spring.dao.BookDAO#updateBook(com.nay.spring.model.Book,
	 * int)
	 */
	@Override
	public void updateBook(Book book, int id) {
		Session session = sessionFactory.getCurrentSession();
		Book book2 = session.byId(Book.class).load(id);
		book2.setAuthor(book.getAuthor());
		book2.setTitle(book.getTitle());
		session.flush(); // session.update(book2);

	}

	/*
	 * delete information specific book
	 * 
	 * @see com.nay.spring.dao.BookDAO#deleteBook(int)
	 */
	@Override
	public void deleteBook(int id) {
		Session session = sessionFactory.getCurrentSession();
		Book book = session.byId(Book.class).load(id);
		session.delete(book);

	}

}
