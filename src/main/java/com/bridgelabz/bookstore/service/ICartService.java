package com.bridgelabz.bookstore.service;

import java.util.List;

import com.bridgelabz.bookstore.dto.CartItemDTO;
import com.bridgelabz.bookstore.model.CartItem;

public interface ICartService 
{
	public abstract List<CartItem> getCart(long cartid);
	public abstract CartItem addToCart(CartItemDTO dto,long cartid);
	public abstract CartItem deleteCartItem(String bookName);
}
