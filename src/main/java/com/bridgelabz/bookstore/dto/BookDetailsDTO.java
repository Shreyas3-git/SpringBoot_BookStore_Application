package com.bridgelabz.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDetailsDTO 
{
	public String bookName;
	public String bookAuthor;
	public String bookDescription;
	public Double bookPrice;
	public int quantity;
	public String bookImage;
	public double bookRating;

}
