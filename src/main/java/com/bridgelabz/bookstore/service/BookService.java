package com.bridgelabz.bookstore.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookstore.dto.BookDetailsDTO;
import com.bridgelabz.bookstore.dto.BookUserDTO;
import com.bridgelabz.bookstore.dto.CartItemDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.model.BookDetails;
import com.bridgelabz.bookstore.model.BookUser;
import com.bridgelabz.bookstore.model.CartItem;
//import com.bridgelabz.bookstore.model.BookUser;
import com.bridgelabz.bookstore.repository.IBookRepository;
import com.bridgelabz.bookstore.repository.ICartRepository;
//import com.bridgelabz.bookstore.repository.IUserRepository;
import com.bridgelabz.bookstore.repository.IUserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class BookService implements IBookService
{
	@Autowired
	private IBookRepository bookRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private ICartRepository cartRepository;

	
	@Override
	public List<BookDetails> retriveAllBooks() 
	{
//		BookUserDTO bookdto = new BookUserDTO();
//		Optional<BookUser> isUser = userRepository.findByEmailId(bookdto.getEmailId());
//		if(isUser.isPresent())
//		{
			List<BookDetails> bookEntity = bookRepository.findAll();
			return bookEntity;
//		}
//		else
//		{
//			log.info("Exception occure user not found:");
//			return null;
//		}
		

	}

	@Override
	public BookDetails getBookByName(String name) 
	{
		BookDetails getOneBook = bookRepository.findByBookName(name).orElse(null);
		return getOneBook;
	}

	@Override
	public BookDetails getnewBookArival() 
	{
		List<BookDetails> bookEntity = bookRepository.findAll();
		return null;
	}

	@Override
	public List<BookDetails> getBookhigherTolowerPresidence() 
	{
		List<BookDetails> bookDetails = bookRepository.findAll();

		Collections.sort(bookDetails, new Comparator<BookDetails>() {

			@Override
			public int compare(BookDetails o1, BookDetails o2) {
				return o2.getBookPrice().compareTo(o1.getBookPrice());
			}

		});

		
		return bookDetails;
	}
	

	@Override
	public List<BookDetails> getBooklowerTohigherPresidence() 
	{
		List<BookDetails> bookDetails = bookRepository.findAll();
		
		Collections.sort(bookDetails, new Comparator<BookDetails>() {

			@Override
			public int compare(BookDetails o1, BookDetails o2) {
				return o1.getBookPrice().compareTo(o2.getBookPrice());
			}

		});

		return bookDetails;

	}

	@Override
	public BookDetails insertBook(BookDetailsDTO dto) 
	{
		BookDetails bookEntity = new BookDetails(dto);
		bookRepository.save(bookEntity);
		return bookEntity;
	}

	@Override
	public Optional<BookDetails> updateBook(String name, BookDetailsDTO dto) 
	{
		Optional<BookDetails> bookEntity = bookRepository.findByBookName(name);
		CartItem cart = new CartItem();

		/**
		 * cartRepository.findByBookid(id).orEles(null);
		 * cartRepository.setBookName(dto.getBookName());
		 * ..
		 * ..
		 *..
		 *cartRepository.save(cartEntity);
		 * 		 */
		if(bookEntity.isPresent())
		{
			bookEntity.get().setBookAuthor(dto.getBookAuthor());
			bookEntity.get().setBookDescription(dto.getBookDescription());
			bookEntity.get().setBookImage(dto.getBookImage());
			bookEntity.get().setBookPrice(dto.getBookPrice());
			bookEntity.get().setQuantity(dto.getQuantity());
			bookEntity.get().setBookRating(dto.getBookRating());
			
			
			cart.setBookAuthor(dto.getBookAuthor());
			cart.setBookDescirption(dto.getBookDescription());
			cart.setBookImage(dto.getBookImage());
			cart.setBookPrice(dto.getBookPrice());
			cart.setBookName(dto.getBookName());
			cart.setQuantity(dto.getQuantity());
			
			cartRepository.save(cart);
			bookRepository.save(bookEntity.get());
			return bookEntity;
		}
		else
		{
			log.info("Book Not Present Exception");
			return null;
		}
		
	}

	@Override
	public Optional<BookDetails> updateBookPrice(String name, double price) 
	{
		Optional<BookDetails> getOneBook = bookRepository.findByBookName(name);
		if (getOneBook.isPresent()) 
		{
			getOneBook.get().setBookPrice(price);
			bookRepository.save(getOneBook.get());
			return getOneBook;
		}
		else
		{
			log.info("Book not found Exception:");
			return null;
		}
	}

	@Override
	public Optional<BookDetails> updateBookQuantity(String name, int quantity) {
		
		Optional<BookDetails> getBook = bookRepository.findByBookName(name);
		if (getBook.isPresent()) 
		{
			getBook.get().setQuantity(quantity);
			bookRepository.save(getBook.get());
			return getBook;
		}
		else
		{
			log.info("Book not found Exception:");
			return null;
		}
		
	}

	@Override
	public Optional<BookDetails> deleteBook(String name) {
		Optional<BookDetails> deleteBook = bookRepository.findByBookName(name);
		if(deleteBook.isPresent())
		{
			bookRepository.delete(deleteBook.get());
			return null;
		}
		else
		{
			log.info("book name does not exist exception");
			return null;
		}
	}

	@Override
	public int getCountOfBooks() 
	{
		List<BookDetails> bookCount = bookRepository.findAll();
		return bookCount.size();
	}

	
}
