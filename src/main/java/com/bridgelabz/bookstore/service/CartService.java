package com.bridgelabz.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookstore.dto.BookDetailsDTO;
import com.bridgelabz.bookstore.dto.BookUserDTO;
import com.bridgelabz.bookstore.dto.CartItemDTO;
import com.bridgelabz.bookstore.model.BookDetails;
import com.bridgelabz.bookstore.model.BookUser;
import com.bridgelabz.bookstore.model.CartItem;
import com.bridgelabz.bookstore.repository.IBookRepository;
import com.bridgelabz.bookstore.repository.ICartRepository;
import com.bridgelabz.bookstore.repository.IUserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CartService implements ICartService
{
	
	@Autowired
	private ICartRepository cartRepository; 
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IBookRepository bookRepository;
	
	@Override
	public List<CartItem> getCart(long userid) 
	{
//		List<BookDetails> bookItem = cartRepository.findAll();
//		List<CartItem> cartItem = cartRepository.findAll();
//		Optional<BookUser> user = userRepository.findById(userid);
//		if (user.isPresent()) 
//		{
//			if (!cartItem.isEmpty()) 
//			{
				return cartRepository.findAll();
//			} 
//			else 
//			{
//				log.error("Cart is empty item not found Exception");
//				return null;
//			}
//			
//		}
//		else 
//		{
//			log.error("User not found exception:");
//			return null;
//		}
//		
	}

	@Override
	public CartItem addToCart(CartItemDTO dto,long userid) 
	{
//		Optional<BookUser> users = userRepository.findById(userid);
//		if (users.isPresent()) 
//		{
			CartItem cart = new CartItem();
			cart.setBookName(dto.getBookName());
			cart.setBookAuthor(dto.getBookAuthor());
			cart.setBookDescirption(dto.getBookDescirption());
			cart.setBookImage(dto.getBookImage());
			cart.setBookPrice(dto.getBookPrice());
			cart.setQuantity(dto.getQuantity());
			cartRepository.save(cart);
			return cart;
//		}
//		else 
//		{
//			log.error("User not found Exception:");
//			return null;
//		}
		
	}


	@Override
	public CartItem deleteCartItem(String bookName) 
	{
		Optional<CartItem> cart = cartRepository.findByBookName(bookName);
		if (cart.isPresent()) 
		{
			cartRepository.delete(cart.get());
			return null;
		}
		else
		{
			return null;
		}
	}

}
