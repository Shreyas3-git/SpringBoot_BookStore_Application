package com.bridgelabz.bookstore.service;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.bookstore.dto.BookDetailsDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.model.BookDetails;


public interface IBookService 
{
	public abstract List<BookDetails> retriveAllBooks();
	public abstract BookDetails getBookByName(String name);
	public abstract BookDetails getnewBookArival();
	public abstract  int getCountOfBooks();
	public abstract List<BookDetails> getBookhigherTolowerPresidence();
	public abstract List<BookDetails> getBooklowerTohigherPresidence();
	public abstract BookDetails insertBook(BookDetailsDTO dto);
	public abstract Optional<BookDetails> updateBook(String name,BookDetailsDTO dto);
	public abstract Optional<BookDetails> updateBookPrice(String name,double price);
	public abstract Optional<BookDetails> updateBookQuantity(String name,int quantity);
	public abstract Optional<BookDetails> deleteBook(String name);
	
}
