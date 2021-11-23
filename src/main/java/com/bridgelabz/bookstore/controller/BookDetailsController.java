package com.bridgelabz.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstore.dto.BookDetailsDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.model.BookDetails;
import com.bridgelabz.bookstore.service.IBookService;

@EnableAutoConfiguration
@RestController
//@RequestMapping("/Book-items")
public class BookDetailsController 
{
	@Autowired
	private IBookService bookService;
	
	@GetMapping("/getbooks")
	public ResponseEntity<ResponseDTO> getAllBooks() 
	{
		List<BookDetails> allBooks = bookService.retriveAllBooks();
		ResponseDTO dto = new ResponseDTO("All Books retrived sucessfully:",allBooks);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	 
	@GetMapping("/getBook")
	public ResponseEntity<ResponseDTO> getOneBook(@RequestParam String name) 
	{
		BookDetails getOneBook = bookService.getBookByName(name);
		ResponseDTO dto = new ResponseDTO("Book retrived sucessfully for name =>"+name, getOneBook);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@GetMapping("/newbook")
	public ResponseEntity<ResponseDTO> newBookArival()
	{
		BookDetails getNewBook = bookService.getnewBookArival();
		ResponseDTO dto = new ResponseDTO("new Book Arived sucessfully:", getNewBook);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}

	@GetMapping("/bookCount")
	public ResponseEntity<ResponseDTO> getBookCount()
	{
		int bookCount = bookService.getCountOfBooks();
		ResponseDTO dto = new ResponseDTO("Book count will be:",bookCount);
		return new ResponseEntity(dto,HttpStatus.OK);
	}
	
		
	@GetMapping("/hightTolow")
	public ResponseEntity<ResponseDTO> bookWithHigherToLowerOrder()
	{
		List<BookDetails> highToLowOrder = bookService.getBookhigherTolowerPresidence();
		ResponseDTO dto = new ResponseDTO("getAll Books Higher order to lower order:", highToLowOrder);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@GetMapping("/lowTohight")
	public ResponseEntity<ResponseDTO> bookWithLowerOrderToHigher()
	{
		List<BookDetails> lowTohighOrder = bookService.getBooklowerTohigherPresidence();
		ResponseDTO dto = new ResponseDTO("getAll Books Lower order to Higher order:", lowTohighOrder);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}

	
	@PostMapping("/addBook")
	public ResponseEntity<ResponseDTO> addBook(@RequestBody BookDetailsDTO bookDto)
	{
		BookDetails addBook = bookService.insertBook(bookDto);
		ResponseDTO dto = new ResponseDTO("Book added sucessfully ", addBook);
		return new ResponseEntity<>(dto,HttpStatus.CREATED);
	}			
	
	@PutMapping("/updateBook/{name}")
	public ResponseEntity<ResponseDTO> updateBook(@RequestParam String name,@RequestBody BookDetailsDTO bookDto)
	{
		Optional<BookDetails> updateBook = bookService.updateBook(name, bookDto);		
		ResponseDTO dto = new ResponseDTO("Book updated sucessfully ", updateBook);
		return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);

	}
	

	@DeleteMapping("/deleteBook")
	public ResponseEntity<ResponseDTO> deleteBook(@RequestParam String name)
	{
		Optional<BookDetails> deleteBookByName = bookService.deleteBook(name);
		ResponseDTO dto = new ResponseDTO("Book deleted sucessfully for name: "+ name, deleteBookByName);
		return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
	}
	
}
