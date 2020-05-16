package com.example.springbootcrud2databaseconnect.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootcrud2databaseconnect.model.Book;
import com.example.springbootcrud2databaseconnect.repository.BookRepository;


@Service
public class BookService 
{
	@Autowired
	BookRepository bookRepository;
	
	public List<Book> getAllBooks()
	{
		List<Book> books = new ArrayList<Book>();
		bookRepository.findAll().forEach(book -> books.add(book));
		return books;
	}
	
	public Optional<Book> getBookById(int id)   
	{  
		//System.out.println(bookRepository.findById(id).get());
		return bookRepository.findById(id);  
	}  
	
	public List<Book> getBookByAuthor(String author)
	{
		List<Book> books = new ArrayList<Book>();
		bookRepository.findByAuthorContainingIgnoreCase(author).forEach(book -> books.add(book));
		return books;
	}
	  
	public List<Book> getBookByName(String bookname)
	{
		return bookRepository.findByBooknameContainingIgnoreCase(bookname);
	}
	
	public void save(Book books)   
	{  
		bookRepository.save(books);  
	}  
	  

}

