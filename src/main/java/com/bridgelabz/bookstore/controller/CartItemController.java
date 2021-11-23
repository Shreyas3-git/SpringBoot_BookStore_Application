package com.bridgelabz.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstore.dto.CartItemDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.model.CartItem;
import com.bridgelabz.bookstore.repository.ICartRepository;
import com.bridgelabz.bookstore.service.ICartService;

@RestController
public class CartItemController 
{

	@Autowired
	private ICartService cartService;
	
	@GetMapping("/getcart")
	public ResponseEntity<ResponseDTO> getAllItemsInCart()
	{
		List<CartItem> retriveAll = cartService.getCart(1);
		ResponseDTO dto = new ResponseDTO("retrived all items in a cart successfully:",retriveAll);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<ResponseDTO> addItemInCart(@RequestBody CartItemDTO dto)
	{
		CartItem addCart = cartService.addToCart(dto, 0);
		ResponseDTO response = new ResponseDTO("item added in a cart successfully:",addCart);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
		
	@DeleteMapping("/deleteitem")
	public ResponseEntity<ResponseDTO> removeCartItem(@RequestParam String name)
	{
		CartItem deleteItem = cartService.deleteCartItem(name);
		ResponseDTO dto = new ResponseDTO("Item in cart deleted successfully for name =>" +name,deleteItem);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
}
