package com.bridgelabz.bookstore.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookUserDTO 
{
//	@NotNull(message = "user name should not be null")	
	public String fullName;
//	@NotNull(message = "user date of birth should not be null")	
	public LocalDate dob;
//	@NotNull(message = "user address should not be null")	
	public String address;
//	@FutureOrPresent(message="register date should be future date or present date only")
	public LocalDate registerDate = LocalDate.now();
//	@FutureOrPresent(message="updated date should be future date or present date only")
	public LocalDate updatedDate = LocalDate.now();
//	@Email(message = "user emailId does not matches pattern")
	public String emailId;
//	@NotNull(message = "Password should not be null")
	public String password;

}
