package com.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookclub.models.Book;
import com.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	//GET ALL BOOKS
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	//FIND ONE
	public Book oneBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}else {
			return null;
		}
	}
	
	//CREATE A NEW BOOK
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	//UPDATE BOOK
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	
	//DELETE BOOK
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	
	
}
